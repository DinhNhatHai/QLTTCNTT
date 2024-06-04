package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Device;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface DeviceService {
    List<Device> findAll();
    Optional<Device> getDeviceById(Long id);
    void save(Device device);
    void deleteById(Long id);
}