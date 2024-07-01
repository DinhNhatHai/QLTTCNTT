package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.EquipmentRepairTicket;
import com.EquipMgmt.EquipMgmtspringboot.Repository.EquipmentRepairTicketRepository;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
@Service
public class PdfService {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private EquipmentRepairTicketRepository equipmentRepairTicketRepository;

    public ByteArrayInputStream generatePdf(Long id) throws IOException {
        Optional<EquipmentRepairTicket> replacementRecord = equipmentRepairTicketRepository.findById(id);
        if (replacementRecord.isPresent()) {
            EquipmentRepairTicket repairTicket = replacementRecord.get();

            Context context = new Context();
            context.setVariable("idEquipment", repairTicket.getEquipment().getSerialNumber());
            context.setVariable("comment", repairTicket.getComment());
            context.setVariable("department", repairTicket.getDepartment().getDepartmentName());
            context.setVariable("receivedDate", repairTicket.getReceivedDate());
            context.setVariable("processingTime", repairTicket.getProcessingTime());
            context.setVariable("description",repairTicket.getDescription());
            context.setVariable("comment", repairTicket.getComment());

            String htmlContent = templateEngine.process("admin/equipment_repair_ticket/preview", context);

            ByteArrayOutputStream target = new ByteArrayOutputStream();
            HtmlConverter.convertToPdf(htmlContent, target);

            return new ByteArrayInputStream(target.toByteArray());
        } else {
            throw new RuntimeException("Record not found");
        }
    }
}
