package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import com.EquipMgmt.EquipMgmtspringboot.Services.CategoryService;
import com.EquipMgmt.EquipMgmtspringboot.Services.ReportService;
import com.EquipMgmt.EquipMgmtspringboot.Services.StorageService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private ReportService reportService;

    @GetMapping()
    public String index(Model model, @Param("keyword") String keyword) {
        List<Category> list = this.categoryService.getAll();
        if (keyword != null) {
            list = this.categoryService.search(keyword);
        }
        model.addAttribute("list", list);
        return "admin/category/list";
    }
    @GetMapping("/excel")
    public void generateExcelReport (HttpServletResponse response) throws Exception {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=Category.xls";

        response.setHeader(headerKey, headerValue);

        reportService.exportExcelCategory(response);

        response.flushBuffer();
    }
    @GetMapping("/create")
    public String create (Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/category/create";

    }

    @PostMapping("/create")
    public String save (@ModelAttribute("category") Category category, @RequestParam("fileImage") MultipartFile file ) throws
            IOException {
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        category.setImage(fileName);
        if (this.categoryService.create(category)) {
            return "admin/category/create";
        } else {
            return "redirect:/admin/category";
        }

    }

    @GetMapping("/edit/{id}")
    public String edit (Model model, @PathVariable("id") Long id){
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/edit";
    }
    @PostMapping("/edit")
    public String update (@ModelAttribute("category") Category category, @RequestParam("fileImage") MultipartFile
            file){

        String fileName = file.getOriginalFilename();
        boolean isEmpty = fileName == null || fileName.trim().isEmpty();
        if (!isEmpty) {
            this.storageService.store(file);
            category.setImage(fileName);
        }
        if (this.categoryService.update(category)) {
            return "admin/category/edit";
        } else {
            return "redirect:/admin/category";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete (Model model, @PathVariable("id") Long id){
        if (this.categoryService.delete(id)) {
            return "redirect:/admin/category";
        } else {
            return "redirect:/admin/category";
        }
    }

}

