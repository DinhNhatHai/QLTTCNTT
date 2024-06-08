package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Receipt;
import com.EquipMgmt.EquipMgmtspringboot.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public List<Receipt> findAll() {
        return receiptRepository.findAll();
    }

    @Override
    public Optional<Receipt> getReceiptById(Long id) {
        return receiptRepository.findById(id);
    }

    @Override
    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public void deleteById(Long id) {
        receiptRepository.deleteById(id);
    }
}
