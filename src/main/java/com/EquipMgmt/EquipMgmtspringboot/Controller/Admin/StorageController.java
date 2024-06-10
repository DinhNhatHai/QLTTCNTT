package com.EquipMgmt.EquipMgmtspringboot.Controller.Admin;

import com.EquipMgmt.EquipMgmtspringboot.Models.Storage;
import com.EquipMgmt.EquipMgmtspringboot.Services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping
    public String getAllStorages(Model model) {
        List<Storage> storages = storageService.getAllStorages();
        model.addAttribute("storages", storages);
        return "admin/storage/list";
    }

    @GetMapping("/search")
    public String searchStorages(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Storage> storages = storageService.searchStorages(name);
        model.addAttribute("storages", storages);
        return "admin/storage/list";
    }

    @GetMapping("/create")
    public String createStorageForm(Model model) {
        model.addAttribute("storage", new Storage());
        return "admin/storage/create";
    }

    @PostMapping("/create")
    public String createStorage(@ModelAttribute("storage") Storage storage) {
        storageService.saveStorage(storage);
        return "redirect:/admin/storage";
    }

    @GetMapping("/edit/{id}")
    public String editStorageForm(@PathVariable Long id, Model model) {
        Storage storage = storageService.getStorageById(id);
        if (storage != null) {
            model.addAttribute("storage", storage);
            return "admin/storage/edit";
        } else {
            return "redirect:/admin/storage";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateStorage(@PathVariable Long id, @Valid @ModelAttribute("storage") Storage storageDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("storage", storageDetails);
            return "admin/storage/edit";
        }

        Storage existingStorage = storageService.getStorageById(id);
        if (existingStorage != null) {
            existingStorage.setStorageName(storageDetails.getStorageName());
            existingStorage.setLocation(storageDetails.getLocation());
            storageService.saveStorage(existingStorage);
        }
        return "redirect:/admin/storage";
    }

    @GetMapping("/delete/{id}")
    public String deleteStorage(@PathVariable("id") Long id) {
        storageService.deleteStorage(id);
        return "redirect:/admin/storage";
    }
}
