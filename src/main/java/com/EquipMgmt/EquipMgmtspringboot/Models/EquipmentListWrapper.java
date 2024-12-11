package com.EquipMgmt.EquipMgmtspringboot.Models;

import java.util.List;

public class EquipmentListWrapper {
    private List<Equipment> equipments;

    // Constructor rỗng
    public EquipmentListWrapper() {
    }

    // Constructor với danh sách các thiết bị
    public EquipmentListWrapper(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    // Getter và Setter
    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}

