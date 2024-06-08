package com.EquipMgmt.EquipMgmtspringboot.Models;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtils {
    public static String formatCurrency(Long price) {
        if (price == null) {
            return "0 VNĐ";
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return formatter.format(price).replace("₫", "VNĐ");
    }
}
