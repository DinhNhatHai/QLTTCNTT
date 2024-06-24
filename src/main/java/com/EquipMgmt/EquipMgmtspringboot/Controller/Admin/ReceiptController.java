package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.*;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private StatusEquipmentService statusEquipmentService;

    @Autowired
    private StatusEquipmentTypeService statusEquipmentTypeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String listReceipts(Model model) {
        model.addAttribute("receipts", receiptService.getAllReceipts());
        model.addAttribute("utils", new CurrencyUtils());
        return "admin/receipt/list";
    }

    @GetMapping("/create")
    public String createReceiptForm(Model model) {
        model.addAttribute("receipt", new Receipt());
        model.addAttribute("utils", new CurrencyUtils());
        EquipmentForm equipmentForm = new EquipmentForm();
        equipmentForm.getEquipments().add(new Equipment());
        model.addAttribute("equipmentForm", equipmentForm);
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("warehouses", warehouseService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vendors", vendorService.findAll());
        return "admin/receipt/create";
    }

    @PostMapping("/create")
    public String createReceipt(@Valid @ModelAttribute("receipt") Receipt receipt,
                                @Valid @ModelAttribute("equipmentForm") EquipmentForm equipmentForm,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("utils", new CurrencyUtils());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("warehouses", warehouseService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("vendors", vendorService.findAll());
            return "admin/receipt/create";
        }

        List<Equipment> equipments = equipmentService.saveAllEquipments(equipmentForm.getEquipments());
        receipt.setEquipments(equipments);
        receiptService.saveReceipt(receipt);

        return "redirect:/admin/receipt";
    }

    @PostMapping("/create-equipments")
    @ResponseBody
    public ResponseEntity<?> createEquipments(@Valid @ModelAttribute("equipmentForm") EquipmentForm equipmentForm,
                                              BindingResult result,
                                              Model model) {

        List<Equipment> savedEquipments = new ArrayList<>();
        for (Equipment equipment : equipmentForm.getEquipments()) {
            Equipment savedEquipment = equipmentService.saveEquipment(equipment);
            savedEquipments.add(savedEquipment);
        }

        return ResponseEntity.ok(savedEquipments);
    }

//    @PostMapping("/create-equipments")
//    @ResponseBody
//    public ResponseEntity<Equipment> createEquipment(@Valid @ModelAttribute("equipmentForm") EquipmentForm equipmentForm,
//                                                     BindingResult result,
//                                                     Model model) {
//        if (result.hasErrors()) {
//            // Xử lý lỗi nếu có
//            return ResponseEntity.badRequest().build();
//        }
//
//        Equipment savedEquipment = equipmentService.saveEquipment(equipmentForm.getEquipments().get(0)); // Lấy equipment đầu tiên trong list
//        return ResponseEntity.ok(savedEquipment);
//    }


//    @PostMapping("/create-equipments")
//    public String createEquipment(@Valid @ModelAttribute("equipmentForm") EquipmentForm equipmentForm,
//                                  BindingResult result,
//                                  Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("brands", brandService.findAll());
//            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
//            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
//            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
//            model.addAttribute("categories", categoryService.getAll());
//            return "admin/receipt/create";
//        }
//
//        equipmentService.saveAllEquipments(equipmentForm.getEquipments());
//        equipmentForm.getEquipments().clear();
//        equipmentForm.getEquipments().add(new Equipment());
//
//        // Thêm thông báo thành công vào Model để hiển thị trên View
//        model.addAttribute("successMessage", "Thêm trang thiết bị thành công!");
//
//        // Load lại các dữ liệu cần thiết cho form
//        model.addAttribute("equipmentForm", equipmentForm);
//        model.addAttribute("brands", brandService.findAll());
//        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
//        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
//        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
//        model.addAttribute("categories", categoryService.getAll());
//
//        return "admin/receipt/create";
//    }


    @GetMapping("/edit/{id}")
    public String editReceiptForm(@PathVariable Long id, Model model) {
        Receipt receipt = receiptService.getReceiptById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu nhập kho có Id: " + id));
        model.addAttribute("receipt", receipt);
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("equipments", equipmentService.getAllEquipments());
        model.addAttribute("warehouses", warehouseService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("vendors", vendorService.findAll());
        return "admin/receipt/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateReceipt(@PathVariable Long id, @Valid @ModelAttribute Receipt receipt, BindingResult result,
                                Model model, @RequestParam("equipmentIds") List<Long> equipmentIds) {
        if (result.hasErrors()) {
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("equipments", equipmentService.getAllEquipments());
            model.addAttribute("warehouses", warehouseService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("vendors", vendorService.findAll());
            return "admin/receipt/edit";
        }

        // Xử lý danh sách thiết bị
        List<Equipment> equipments = equipmentService.getAllEquipmentsByIds(equipmentIds);
        receipt.setEquipments(equipments);

        receipt.setId(id);
        receiptService.saveReceipt(receipt);
        return "redirect:/admin/receipt";
    }

    @GetMapping("/delete/{id}")
    public String deleteReceipt(@PathVariable Long id) {
        Receipt receipt = receiptService.getReceiptById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại phiếu nhập kho có Id: " + id));
        receiptService.deleteReceipt(id);
        return "redirect:/admin/receipt";
    }
}
