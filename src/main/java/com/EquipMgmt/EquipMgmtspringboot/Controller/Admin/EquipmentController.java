package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentForm;
import com.EquipMgmt.EquipMgmtspringboot.Services.*;
import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private StatusEquipmentTypeService statusEquipmentTypeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StatusEquipmentService statusEquipmentService;

    @Autowired
    private EquipmentTypeService equipmentTypeService;
    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping
    public String listDevices(Model model) {
        List<Equipment> equipments = equipmentService.getAllEquipments();
        model.addAttribute("equipments", equipments);
        return "admin/equipment/list";
    }

    @GetMapping("/create")
    public String createEquipmentForm(Model model) {
        EquipmentForm equipmentForm = new EquipmentForm();
        equipmentForm.getEquipments().add(new Equipment());
        model.addAttribute("equipmentForm", equipmentForm);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        return "admin/equipment/create";
    }

    @PostMapping("/create")
    public String createEquipment(@Valid @ModelAttribute("equipmentForm") EquipmentForm equipmentForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            return "admin/equipment/create";
        }

        equipmentService.saveAllEquipments(equipmentForm.getEquipments());
        equipmentForm.getEquipments().clear();
        equipmentForm.getEquipments().add(new Equipment());

        // Thêm thông báo thành công vào Model để hiển thị trên View
        model.addAttribute("successMessage", "Thêm trang thiết bị thành công!");

        // Load lại các dữ liệu cần thiết cho form
        model.addAttribute("equipmentForm", equipmentForm);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("categories", categoryService.getAll());

        return "admin/equipment/create";
    }

    @GetMapping("/edit/{id}")
    public String editEquipmentForm(@PathVariable Long id, Model model) {
        Equipment equipment = equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại hệ thống thiết bị có Id: " + id));
        model.addAttribute("equipment", equipment);
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
        model.addAttribute("statusEquipments", statusEquipmentService.findAll());
        model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
        model.addAttribute("categories", categoryService.getAll());
        return "admin/equipment/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEquipment (@PathVariable Long id, @Valid @ModelAttribute Equipment equipment, BindingResult result, Model model,  RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            model.addAttribute("statusEquipmentTypes", statusEquipmentTypeService.findAll());
            model.addAttribute("statusEquipments", statusEquipmentService.findAll());
            model.addAttribute("equipmentTypes", equipmentTypeService.findAll());
            model.addAttribute("categories", categoryService.getAll());
            return "admin/equipment/edit";
        }

        equipment.setId(id);
        equipmentService.saveEquipment(equipment);

        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật trang thiết bị thành công!");

        return "redirect:/admin/equipment";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipment (@PathVariable Long id, Model model,  RedirectAttributes redirectAttributes) {
        Equipment equipment = equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại hệ thống thiết bị có Id:" + id));
        equipmentService.deleteEquipment(id);

        redirectAttributes.addFlashAttribute("successMessage", "Xóa trang thiết bị thành công!");
        return "redirect:/admin/equipment";
    }
    @GetMapping("/detail/{id}")
    public String detailEquipment (@PathVariable("id") Long id, Model model){
        Optional<Equipment> equipment  = equipmentService.getEquipmentById(id);
        model.addAttribute("equipment",equipment.get());
        return "admin/equipment/detail";
    }
    @GetMapping(value = "/generateQR", produces = "image/png")
    @ResponseBody
    public byte[] generateQRCode(@RequestParam("id") Long id) throws WriterException, IOException {
        String url = "http://localhost:8080/admin/equipment/detail/" + id;
        return qrCodeService.generateQRCodeImage(url, 200, 200);
    }
}

