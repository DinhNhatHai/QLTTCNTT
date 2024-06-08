package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentRepairTicket;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/equipment-repair-ticket")
public class EquipmentRepairTicketController {
    @Autowired
    private EquipmentRepairTicketService equipmentRepairTicketService;
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
        List<EquipmentRepairTicket> equipmentRepairTickets = this.equipmentRepairTicketService.getAll();
        if (keyword != null) {
            equipmentRepairTickets = this.equipmentRepairTicketService.search(keyword);
        }
        model.addAttribute("replacementRepair",equipmentRepairTickets);
        return  "admin/equipment_repair_ticket/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("equipments", this.equipmentService.findAll());
        model.addAttribute("equipmentTypes",this.equipmentTypeService.findAll());
        model.addAttribute("departments", this.departmentService.findAll());
        model.addAttribute("employees", this.employeeService.findAll());
        EquipmentRepairTicket replacementRepairTicket = new EquipmentRepairTicket();
        model.addAttribute("replacementRepair", replacementRepairTicket);
        return  "admin/equipment_repair_ticket/create";
    }

    @PostMapping("/create")
    public String save (@ModelAttribute("replacementRepair") EquipmentRepairTicket equipmentRepairTicket) {
        if (this.equipmentRepairTicketService.create(equipmentRepairTicket)) {
            return "admin/equipment_repair_ticket/create";
        } else {
            return "redirect:/admin/equipment-repair-ticket";
        }

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("replacementRepair", this.equipmentRepairTicketService.findById(id));
        model.addAttribute("equipments", this.equipmentService.findAll());
        model.addAttribute("equipmentTypes",this.equipmentTypeService.findAll());
        model.addAttribute("departments", this.departmentService.findAll());
        model.addAttribute("employees", this.employeeService.findAll());
        return  "admin/equipment_repair_ticket/edit";
    }
    @PostMapping("/edit")
    public String update (@ModelAttribute("replacementRepair") EquipmentRepairTicket equipmentRepairTicket) {
        if (this.equipmentRepairTicketService.update(equipmentRepairTicket)) {
            return "admin/replace_repair_ticket/create";
        } else {
            return "redirect:/admin/equipment-repair-ticket";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable("id") Long id) {
        if (this.equipmentRepairTicketService.delete(id)) {
            return "admin/equipment_repair_ticket/create";
        } else {
            return "redirect:/admin/equipment-repair-ticket";
        }
    }
}
