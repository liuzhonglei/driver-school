package com.medal.common.poi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel 读取（2007+新格式）
 * @author	chengesheng
 * @date	2012-4-27 下午03:39:01
 * @note	PoiExcel2k7Helper
 */
public class PoiExcel2k7Helper extends PoiExcelHelper {
    /** 获取sheet列表 */
    public List<String> getSheetList(String filePath, List<String> filterSheets ) {
        ArrayList<String> sheetList = new ArrayList<String>(0);
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
            Iterator<Sheet> iterator = wb.iterator();
            while (iterator.hasNext()) {
                String sheetName = iterator.next().getSheetName();
                if ( !filterSheets.contains( sheetName ) ) {
                    sheetList.add(sheetName);
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
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);

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
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);

            dataList = readExcel(sheet, rows, cols);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}