package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import com.EquipMgmt.EquipMgmtspringboot.Models.Receipt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ReceiptService {
    Receipt saveReceipt(Receipt receipt);
    Optional<Receipt> getReceiptById(Long id);
    List<Receipt> getAllReceipts();
    void deleteReceipt(Long id);
    Receipt createReceiptWithEquipments(Receipt receipt, List<Equipment> equipments);
}