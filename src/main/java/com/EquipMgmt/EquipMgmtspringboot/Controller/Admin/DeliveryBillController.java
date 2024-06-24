package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.DeliveryBill;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/delivery-bill")
public class DeliveryBillController {
    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DeliveryBillService deliveryBillService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String listDeliveryBills (Model model) {
        model.addAttribute("deliveryBills", deliveryBillService.findAll());
        return "admin/delivery_bill/list";
    }

    @GetMapping("/create")
    public String createDeliveryBillForm(Model model) {
        model.addAttribute("deliveryBill", new DeliveryBill());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("warehouses", warehouseService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        return "admin/delivery_bill/create";
    }

    @PostMapping("/create")
    public String createReceipt(@Valid @ModelAttribute DeliveryBill deliveryBill, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("warehouses", warehouseService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("departments", departmentService.findAll());
            return "admin/delivery_bill/create";
        }
        deliveryBillService.save(deliveryBill);
        return "redirect:/admin/delivery-bill";
    }

    @GetMapping("/edit/{id}")
    public String editDeliveryBillForm(@PathVariable Long id, Model model) {
        DeliveryBill deliveryBill = deliveryBillService.getDeliveryBillById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu xuất kho có Id: " + id));
        model.addAttribute("deliveryBill", deliveryBill);
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("warehouses", warehouseService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        return "admin/delivery_bill/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDeliveryBill (@PathVariable Long id, @Valid @ModelAttribute DeliveryBill deliveryBill, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("warehouses", warehouseService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("departments", departmentService.findAll());
            return "admin/delivery_bill/edit";
        }

        deliveryBill.setId(id);
        deliveryBillService.save(deliveryBill);
        return "redirect:/admin/delivery-bill";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeliveryBill (@PathVariable Long id) {
        DeliveryBill deliveryBill = deliveryBillService.getDeliveryBillById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu xuất kho có Id:" + id));
        deliveryBillService.deleteById(id);
        return "redirect:/admin/delivery-bill";
    }
}
