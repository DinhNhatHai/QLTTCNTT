package com.EquipMgmt.EquipMgmtspringboot.Services;

import com.EquipMgmt.EquipMgmtspringboot.Models.Category;
import com.EquipMgmt.EquipMgmtspringboot.Repository.CategoryRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportService {
    @Autowired
    private CategoryRepository categoryRepository;
    public void exportExcelCategory(HttpServletResponse response) throws Exception{
        List<Category> categories = categoryRepository.findAll();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Category Info");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("STT");
        row.createCell(1).setCellValue("Tên danh mục");
        row.createCell(2).setCellValue("Hiển thị trên màn hình");
        row.createCell(3).setCellValue("Mô tả");
        int dataRowIndex = 1;
        int numberStart = 1;
        for (Category category : categories){
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(numberStart++);
            dataRow.createCell(1).setCellValue(category.getNameCategory());
            if (category.getShowHome() == Boolean.TRUE){
                dataRow.createCell(2).setCellValue("Hiện");
            }
            else {
                dataRow.createCell(2).setCellValue("Ẩn");
            }
            dataRow.createCell(3).setCellValue(category.getDescription());
            dataRowIndex++;
        }
        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }
}
