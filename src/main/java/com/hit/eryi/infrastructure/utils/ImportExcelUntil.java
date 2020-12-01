package com.hit.eryi.infrastructure.utils;


import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ImportExcelUntil {

    public static List<List<String>> ReadExcel(MultipartFile file) throws Exception {
        return ReadExcel(file, 0);//默认读取第一个sheet
    }

    public static List<List<String>> ReadExcel(MultipartFile file, int index) throws Exception {
        String fileName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(fileName);
        return ReadXlsx(file, index, extension);

    }

    public static List<List<String>> ReadXlsx(MultipartFile file, int index, String extension) throws Exception {
        Workbook workbook = null;
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        } else {
            throw new Exception("不支持的文件格式");
        }

        Sheet sheet = workbook.getSheetAt(index);
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            List<String> list = new ArrayList<String>();
            if (row != null) {
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    Cell cell = row.getCell(j);
                    if(cell != null){
                        CellType type = cell.getCellTypeEnum();
                        String val = "";
                        if (type == CellType.NUMERIC) {
                            val = GetString(cell);
                        } else if (type == CellType.FORMULA) {
                            val = GetString(cell);
                        } else {
                            val = cell.getStringCellValue();
                        }

                        list.add(val);
                    }
                }
            }
            result.add(list);
        }
        workbook.close();
        return result;
    }

    private static String GetString(Cell cell) {
        String val = "";
        try {
            val = String.valueOf(cell.getStringCellValue());
        } catch (IllegalStateException e) {
            val = String.valueOf(cell.getNumericCellValue());
        }

        if (val.indexOf("E") > -1) {//防止科学计数法  防止数字变成科学记数法
            DecimalFormat df = new DecimalFormat("0");
            val = df.format(cell.getNumericCellValue());
        }

        return val;
    }
}
