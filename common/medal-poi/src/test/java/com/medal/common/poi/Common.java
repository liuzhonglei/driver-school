package com.medal.common.poi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhuji on 2016/8/28.
 */
@Slf4j
public class Common {
    private static final String database_table_filePath = "E:\\code\\idea_workspace\\medal\\common\\medal-poi\\src\\test\\resources\\驾校登记表新20100409.xlsx";

    public static void main(String[] args) {

        PoiExcelHelper helper = PoiExcelHelper.getPoiExcelHelper(database_table_filePath);
        List<String> databaseSheetName = helper.getSheetList(database_table_filePath,new ArrayList<>());
        List<List<String>> databaseExcelContent = new ArrayList<List<String>>();
        for (int i = 0; i < databaseSheetName.size(); i++) {
            databaseExcelContent.addAll(
                    helper.readExcel(database_table_filePath, i, "2-",
                            new String[]{"b","c","d","e","f","g","h","i","j"}) ) ;
        }
        log.info(databaseExcelContent.toString());
    }
}
