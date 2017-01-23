package com.medal.common.poi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel 读取（97-2003格式）
 * @author	chengesheng
 * @date	2012-4-27 下午03:39:01
 * @note	PoiExcel2k3Helper
 */
public class PoiExcel2k3Helper extends PoiExcelHelper {
    /**
     * 获取sheet列表
     */
    public List<String> getSheetList( String filePath, List<String> filterSheets ) {
        List<String> sheetList = new ArrayList<String>(0);
        try {
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
            int i = 0;
            while (true) {
                try {
                    String name = wb.getSheetName(i);
                    if ( !filterSheets.contains( name ) ) {
                        sheetList.add(name);
                    }
                    i++;
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheetList;
    }

    /** 读取Excel文件内容 */
    public List<List<String>> readExcel(String filePath, int sheetIndex, String rows, String columns) {
        List<List<String>> dataList = new ArrayList<List<String>> ();
        try {
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
            HSSFSheet sheet = wb.getSheetAt(sheetIndex);

            dataList = readExcel(sheet, rows, getColumnNumber(sheet, columns));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    /** 读取Excel文件内容 */
    public List<List<String>> readExcel(String filePath, int sheetIndex, String rows, int[] cols) {
        List<List<String>> dataList = new ArrayList<List<String>> ();
        try {
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
            HSSFSheet sheet = wb.getSheetAt(sheetIndex);

            dataList = readExcel(sheet, rows, cols);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}