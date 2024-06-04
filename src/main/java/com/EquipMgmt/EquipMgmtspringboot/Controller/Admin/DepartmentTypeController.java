package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;


import com.EquipMgmt.EquipMgmtspringboot.Models.DepartmentType;
import com.EquipMgmt.EquipMgmtspringboot.Services.DepartmentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/department-type")
public class DepartmentTypeController {

    @Autowired
    private DepartmentTypeService departmentTypeService;

    @GetMapping
    public String listDepartmentTypes(Model model) {
        model.addAttribute("departmentTypes", departmentTypeService.findAll());
        return "admin/department_type/list";
    }

    @GetMapping("/create")
    public String createDepartmentTypeForm(Model model) {
        model.addAttribute("departmentType", new DepartmentType());
        return "admin/department_type/create";
    }

    @PostMapping("/create")
    public String createDepartmentType (@Valid @ModelAttribute DepartmentType departmentType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/department_type/create";
        }
        departmentTypeService.save(departmentType);
        return "redirect:/admin/department-type";
    }


    @GetMapping("/edit/{id}")
    public String editDepartmentTypeForm(@PathVariable Long id, Model model) {
        DepartmentType departmentType = departmentTypeService.getDepartmentTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại phòng ban có Id:" + id));
        model.addAttribute("departmentType", departmentType);
        return "admin/department_type/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDepartmentType(@PathVariable Long id, @Valid @ModelAttribute DepartmentType departmentType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/department_type/edit";
        }
        departmentType.setId(id);
        departmentTypeService.save(departmentType);
        return "redirect:/admin/department-type";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartmentType(@PathVariable Long id) {
        DepartmentType departmentType = departmentTypeService.getDepartmentTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tồn tại loại phòng ban có Id:" + id));
        departmentTypeService.deleteById(id);
        return "redirect:/admin/department-type";
    }
}

