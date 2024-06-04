package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Warehouse;
import com.EquipMgmt.EquipMgmtspringboot.Services.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String listWarehouses (Model model) {
        model.addAttribute("warehouses", warehouseService.findAll());
        return "admin/warehouse/list";
    }

    @GetMapping("/create")
    public String createWarehouseForm (Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "admin/warehouse/create";
    }

    @PostMapping("/create")
    public String createWarehouse (@Valid @ModelAttribute Warehouse warehouse, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/warehouse/create";
        }
        warehouseService.save(warehouse);
        return "redirect:/admin/warehouse";
    }


    @GetMapping("/edit/{id}")
    public String editWarehouseForm(@PathVariable Long id, Model model) {
        Warehouse warehouse = warehouseService.getWarehouseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại thương hiệu có Id:" + id));
        model.addAttribute("warehouse", warehouse);
        return "admin/warehouse/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateWarehouse (@PathVariable Long id, @Valid @ModelAttribute Warehouse warehouse, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/warehouse/edit";
        }
        warehouse.setId(id);
        warehouseService.save(warehouse);
        return "redirect:/admin/warehouse";
    }

    @GetMapping("/delete/{id}")
    public String deleteWarehouse (@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại thương hiệu có Id:" + id));
        warehouseService.deleteById(id);
        return "redirect:/admin/warehouse";
    }
}