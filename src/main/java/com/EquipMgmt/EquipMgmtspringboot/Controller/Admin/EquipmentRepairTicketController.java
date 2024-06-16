package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentRepairTicket;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
@CrossOrigin("*")
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
    @Autowired
    private SpringTemplateEngine springTemplateEngine;
    @Autowired
    private PDFGenrateService pdfGenrateService;
    @Autowired
    private DataService dataService;

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
    public String save(@ModelAttribute("replacementRepair") EquipmentRepairTicket equipmentRepairTicket) {
        LocalDateTime receivedDateTime = LocalDateTime.parse(equipmentRepairTicket.getReceivedDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm"));
        LocalDateTime completeDateTime = LocalDateTime.parse(equipmentRepairTicket.getCompleteDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm"));

        if (receivedDateTime.isAfter(LocalDateTime.now()) || completeDateTime.isAfter(LocalDateTime.now())) {
            return "redirect:/admin/equipment-repair-ticket/create?error=futureDateTime";
        }

        if (receivedDateTime.isAfter(completeDateTime)) {
            return "redirect:/admin/equipment-repair-ticket/create?error=invalidDateRange";
        }

        Duration duration = Duration.between(receivedDateTime, completeDateTime);
        long diffDays = duration.toDays();
        long diffHours = duration.toHours() % 24;
        long diffMinutes = duration.toMinutes() % 60;

        Period period = Period.between(receivedDateTime.toLocalDate(), completeDateTime.toLocalDate());
        int diffYears = period.getYears();
        int diffMonths = period.getMonths();

        StringBuilder processingTimeBuilder = new StringBuilder();
        if (diffYears > 0) {
            processingTimeBuilder.append(diffYears).append(" năm ");
        }
        if (diffMonths > 0) {
            processingTimeBuilder.append(diffMonths).append(" tháng ");
        }
        if (diffDays > 0) {
            processingTimeBuilder.append(diffDays % 30).append(" ngày ");
        }
        if (diffHours > 0) {
            processingTimeBuilder.append(diffHours).append(" giờ ");
        }
        processingTimeBuilder.append(diffMinutes).append(" phút");

        equipmentRepairTicket.setProcessingTime(processingTimeBuilder.toString());

        if (this.equipmentRepairTicketService.create(equipmentRepairTicket)) {
            return "redirect:/admin/equipment-repair-ticket/create";
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
    public String update(@ModelAttribute("replacementRepair") EquipmentRepairTicket equipmentRepairTicket) {
        LocalDateTime receivedDateTime = LocalDateTime.parse(equipmentRepairTicket.getReceivedDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm"));
        LocalDateTime completeDateTime = LocalDateTime.parse(equipmentRepairTicket.getCompleteDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm"));

        if (receivedDateTime.isAfter(LocalDateTime.now()) || completeDateTime.isAfter(LocalDateTime.now())) {
            return "redirect:/admin/equipment-repair-ticket/edit?error=futureDateTime";
        }

        if (receivedDateTime.isAfter(completeDateTime)) {
            return "redirect:/admin/equipment-repair-ticket/edit?error=invalidDateRange";
        }

        Duration duration = Duration.between(receivedDateTime, completeDateTime);
        long diffDays = duration.toDays();
        long diffHours = duration.toHours() % 24;
        long diffMinutes = duration.toMinutes() % 60;

        Period period = Period.between(receivedDateTime.toLocalDate(), completeDateTime.toLocalDate());
        int diffYears = period.getYears();
        int diffMonths = period.getMonths();

        StringBuilder processingTimeBuilder = new StringBuilder();
        if (diffYears > 0) {
            processingTimeBuilder.append(diffYears).append(" năm ");
        }
        if (diffMonths > 0) {
            processingTimeBuilder.append(diffMonths).append(" tháng ");
        }
        if (diffDays > 0) {
            processingTimeBuilder.append(diffDays % 30).append(" ngày ");
        }
        if (diffHours > 0) {
            processingTimeBuilder.append(diffHours).append(" giờ ");
        }
        processingTimeBuilder.append(diffMinutes).append(" phút");

        equipmentRepairTicket.setProcessingTime(processingTimeBuilder.toString());

        if (this.equipmentRepairTicketService.update(equipmentRepairTicket)) {
            return "redirect:/admin/equipment-repair-ticket/edit";
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
    @GetMapping("/preview/{id}")
    public String preview (Model model, @PathVariable("id") Long id){
        model.addAttribute("repairTickets",this.equipmentRepairTicketService.findById(id));
        return "admin/equipment_repair_ticket/preview";
    }
    @PostMapping("/generate")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public String generatePdf(@RequestBody List<EquipmentRepairTicket> equipmentRepairTickets){
        try{
            String finalhtml = null;
            Context data = dataService.setData(equipmentRepairTickets);
            finalhtml = springTemplateEngine.process("preview",data);
            pdfGenrateService.htmltopdf(finalhtml);
            return "admin/equipment_repair_ticket/list";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
