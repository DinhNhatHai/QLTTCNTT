package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Equipment;
import com.EquipMgmt.EquipMgmtspringboot.Models.Receipt;
import com.EquipMgmt.EquipMgmtspringboot.Repository.EquipmentRepository;
import com.EquipMgmt.EquipMgmtspringboot.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    @Transactional
    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public Optional<Receipt> getReceiptById(Long id) {
        return receiptRepository.findById(id);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Receipt createReceiptWithEquipments(Receipt receipt, List<Equipment> equipments) {
        // Set the receipt for each equipment
        equipments.forEach(equipment -> equipment.setReceipt(receipt));
        receipt.setEquipments(equipments);

        // Save the receipt and equipments
        Receipt savedReceipt = receiptRepository.save(receipt);
        equipmentRepository.saveAll(equipments);

        return savedReceipt;
    }
}
