package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.DeliveryBill;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface DeliveryBillService {
    List<DeliveryBill> findAll();
    Optional<DeliveryBill> getDeliveryBillById(Long id);
    void save(DeliveryBill deliveryBill);
    void deleteById(Long id);
}
