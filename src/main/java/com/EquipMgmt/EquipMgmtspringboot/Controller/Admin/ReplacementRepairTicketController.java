package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import com.EquipMgmt.EquipMgmtspringboot.Models.Employee;
import com.EquipMgmt.EquipMgmtspringboot.Models.ReplacementRepairTicket;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/replacement-repair-ticket")
public class ReplacementRepairTicketController {
    @Autowired
    private ReplacementRepairTicketService replacementRepairTicketService;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private EquipmentTypeService equipmentTypeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String index(Model model, @Param("keyword") String keyword) {
        List<ReplacementRepairTicket> replacementRepairTickets = this.replacementRepairTicketService.getAll();
        if (keyword != null) {
            replacementRepairTickets = this.replacementRepairTicketService.search(keyword);
        }
        model.addAttribute("replacementRepair",replacementRepairTickets);
        return  "admin/replacement_repair_ticket/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("equipments", this.equipmentService.findAll());
        model.addAttribute("equipmentTypes",this.equipmentTypeService.findAll());
        model.addAttribute("departments", this.departmentService.findAll());
        model.addAttribute("employees", this.employeeService.findAll());
        ReplacementRepairTicket replacementRepairTicket = new ReplacementRepairTicket();
        model.addAttribute("replacementRepair", replacementRepairTicket);
        return  "admin/replacement_repair_ticket/create";
    }

    @PostMapping("/create")
    public String save (@ModelAttribute("replacementRepair") ReplacementRepairTicket replacementRepairTicket) {
        if (this.replacementRepairTicketService.create(replacementRepairTicket)) {
            return "admin/replace_repair_ticket/create";
        } else {
            return "redirect:/admin/replacement-repair-ticket";
        }

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("replacementRepairs", this.replacementRepairTicketService.findById(id));
        model.addAttribute("equipments", this.equipmentService.findAll());
        model.addAttribute("equipmentTypes",this.equipmentTypeService.findAll());
        model.addAttribute("departments", this.departmentService.findAll());
        model.addAttribute("employees", this.employeeService.findAll());
        return  "admin/replacement_repair_ticket/edit";
    }
    @PostMapping("/edit")
    public String update (@ModelAttribute("replacementRepairs") ReplacementRepairTicket replacementRepairTicket) {
        if (this.replacementRepairTicketService.update(replacementRepairTicket)) {
            return "admin/replace_repair_ticket/create";
        } else {
            return "redirect:/admin/replacement-repair-ticket";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable("id") Long id) {
        if (this.replacementRepairTicketService.delete(id)) {
            return "admin/replace_repair_ticket/create";
        } else {
            return "redirect:/admin/replacement-repair-ticket";
        }
    }

}
