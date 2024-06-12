package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class EquipmentForm {

    @Valid
    private List<Equipment> equipments = new ArrayList<>();

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
