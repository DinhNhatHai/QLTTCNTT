package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementUpgradeTicket;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/replacement-upgrade-ticket")
public class ReplacementUpgradeTicketController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReplacementUpgradeTicketService replacementUpgradeTicketService;

    @Autowired
    private ReplacementUpgradeTicketTypeService replacementUpgradeTicketTypeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String listReplacementUpgradeTickets(Model model) {
        model.addAttribute("replacementUpgradeTickets", replacementUpgradeTicketService.findAll());
        return "admin/replacement_upgrade_ticket/list";
    }

    @GetMapping("/create")
    public String createReplacementUpgradeTicketForm(Model model) {
        model.addAttribute("replacementUpgradeTicket", new ReplacementUpgradeTicket());
        model.addAttribute("replacementUpgradeTicketTypes", replacementUpgradeTicketTypeService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/replacement_upgrade_ticket/create";
    }

    @PostMapping("/create")
    public String createReplacementUpgradeTicket(@Valid @ModelAttribute ReplacementUpgradeTicket replacementUpgradeTicket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("replacementUpgradeTicketTypes", replacementUpgradeTicketTypeService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("departments", departmentService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/replacement_upgrade_ticket/create";
        }
        replacementUpgradeTicketService.save(replacementUpgradeTicket);
        return "redirect:/admin/replacement-upgrade-ticket";
    }

    @GetMapping("/edit/{id}")
    public String editReplacementUpgradeTicketForm(@PathVariable Long id, Model model) {
        ReplacementUpgradeTicket replacementUpgradeTicket = replacementUpgradeTicketService.getReplacementUpgradeTicketById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu có Id: " + id));
        model.addAttribute("replacementUpgradeTicket", replacementUpgradeTicket);
        model.addAttribute("replacementUpgradeTicketTypes", replacementUpgradeTicketTypeService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("employees", employeeService.findAll());
        return "admin/replacement_upgrade_ticket/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateReplacementUpgradeTicket(@PathVariable Long id, @Valid @ModelAttribute ReplacementUpgradeTicket replacementUpgradeTicket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("replacementUpgradeTicketTypes", replacementUpgradeTicketTypeService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("departments", departmentService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("employees", employeeService.findAll());
            return "admin/replacement_upgrade_ticket/edit";
        }

        replacementUpgradeTicket.setId(id);
        replacementUpgradeTicketService.save(replacementUpgradeTicket);
        return "redirect:/admin/replacement-upgrade-ticket";
    }

    @GetMapping("/delete/{id}")
    public String deleteReplacementUpgradeTicket(@PathVariable Long id) {
        ReplacementUpgradeTicket replacementUpgradeTicket = replacementUpgradeTicketService.getReplacementUpgradeTicketById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu có Id: " + id));
        replacementUpgradeTicketService.deleteById(id);
        return "redirect:/admin/replacement-upgrade-ticket";
    }
}
