package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.*;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/receipt")
public class ReceiptController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String listReceipts (Model model) {
        model.addAttribute("receipts", receiptService.findAll());
        model.addAttribute("utils", new CurrencyUtils());
        return "admin/receipt/list";
    }

    @GetMapping("/create")
    public String createReceiptForm(Model model) {
        model.addAttribute("receipt", new Receipt());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.findAll());
        model.addAttribute("warehouses", warehouseService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vendors", vendorService.findAll());
        return "admin/receipt/create";
    }

    @PostMapping("/create")
    public String createReceipt(@Valid @ModelAttribute Receipt receipt, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.findAll());
            model.addAttribute("warehouses", warehouseService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("vendors", vendorService.findAll());
            return "admin/receipt/create";
        }
        receiptService.save(receipt);
        return "redirect:/admin/receipt";
    }

    @GetMapping("/edit/{id}")
    public String editReceiptForm(@PathVariable Long id, Model model) {
        Receipt receipt = receiptService.getReceiptById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu nhập kho có Id: " + id));
        model.addAttribute("receipt", receipt);
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.findAll());
        model.addAttribute("warehouses", warehouseService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vendors", vendorService.findAll());
        return "admin/receipt/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateReceipt (@PathVariable Long id, @Valid @ModelAttribute Receipt receipt, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.findAll());
            model.addAttribute("warehouses", warehouseService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("vendors", vendorService.findAll());
            return "admin/receipt/edit";
        }

        receipt.setId(id);
        receiptService.save(receipt);
        return "redirect:/admin/receipt";
    }

    @GetMapping("/delete/{id}")
    public String deleteReceipt (@PathVariable Long id) {
        Receipt receipt = receiptService.getReceiptById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu nhập kho có Id:" + id));
        receiptService.deleteById(id);
        return "redirect:/admin/receipt";
    }
}
