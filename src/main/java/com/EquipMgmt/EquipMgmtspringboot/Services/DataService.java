package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentRepairTicket;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataService {
    public Context setData(List<EquipmentRepairTicket> ticketList){
        Context context = new Context();
        Map<String, Object> map = new HashMap<>();
        map.put("repairTickets",ticketList);
        context.setVariables(map);
        return  context;
    }
}
