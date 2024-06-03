package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;


import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import com.EquipMgmt.EquipMgmtspringboot.Services.DepartmentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/category-department")
public class CategoryDepartmentController {

    @Autowired
    private DepartmentTypeService departmentTypeService;

    @GetMapping
    public String listDepartments(Model model) {
        List<DepartmentType> departmentTypes = departmentTypeService.getAllDepartmentTypes();
        model.addAttribute("departmentTypes", departmentTypes);
        return "admin/category_department/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("departmentType", new DepartmentType());
        model.addAttribute("showHomeOptions", getShowHomeOptions());
        return "admin/category_department/create";
    }

    @PostMapping("/create")
    public String createDepartment(@Valid @ModelAttribute("departmentType") DepartmentType departmentType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("showHomeOptions", getShowHomeOptions());
            return "admin/category_department/create";
        }
        departmentTypeService.updateDepartmentType(departmentType);
        return "redirect:/admin/category-department";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        DepartmentType departmentType = departmentTypeService.getCategoryDepartmentById(id);
        if (departmentType == null) {
            return "redirect:/admin/category-department";
        }
        model.addAttribute("departmentType", departmentType);
        model.addAttribute("showHomeOptions", getShowHomeOptions());
        return "admin/category_department/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDepartment(@PathVariable("id") Long id, @Valid @ModelAttribute("departmentType") DepartmentType departmentType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("showHomeOptions", getShowHomeOptions());
            return "admin/category_department/edit";
        }
        departmentType.setId(id);
        departmentTypeService.updateDepartmentType(departmentType);
        return "redirect:/admin/category-department";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        departmentTypeService.deleteCategoryDepartment(id);
        return "redirect:/admin/category-department";
    }

    private Map<String, String> getShowHomeOptions() {
        Map<String, String> showHomeOptions = new HashMap<>();
        showHomeOptions.put("Yes", "Yes");
        showHomeOptions.put("No", "No");
        return showHomeOptions;
    }
}

