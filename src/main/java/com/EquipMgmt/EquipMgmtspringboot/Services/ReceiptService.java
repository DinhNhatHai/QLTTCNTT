package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Receipt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ReceiptService {
    List<Receipt> findAll();
    Optional<Receipt> getReceiptById(Long id);
    void save(Receipt receipt);
    void deleteById(Long id);
}