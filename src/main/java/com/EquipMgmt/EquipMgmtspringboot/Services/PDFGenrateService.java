package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

@Service
public class PDFGenrateService {
    public String htmltopdf(String html){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            ConverterProperties converterProperties = new ConverterProperties();
            DefaultFontProvider defaultFontProvider = new DefaultFontProvider();
            converterProperties.setFontProvider(defaultFontProvider);
            HtmlConverter.convertToPdf(html, pdfWriter,converterProperties);
            FileOutputStream fout = new FileOutputStream("E:/ProjectBVUB/FilePDF/user.pdf");
            byteArrayOutputStream.writeTo(fout);
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            fout.close();
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
