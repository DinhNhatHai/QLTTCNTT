package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Brand;
import com.EquipMgmt.EquipMgmtspringboot.Models.DeliveryBill;
import com.EquipMgmt.EquipMgmtspringboot.Repository.DeliveryBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryBillServiceImpl implements DeliveryBillService {

    @Autowired
    private DeliveryBillRepository deliveryBillRepository;

    @Override
    public List<DeliveryBill> findAll() {
        return deliveryBillRepository.findAll();
    }

    @Override
    public Optional<DeliveryBill> getDeliveryBillById(Long id) {
        return deliveryBillRepository.findById(id);
    }

    @Override
    public void save(DeliveryBill deliveryBill) {
        deliveryBillRepository.save(deliveryBill);
    }

    @Override
    public void deleteById(Long id) {
        deliveryBillRepository.deleteById(id);
    }
}
