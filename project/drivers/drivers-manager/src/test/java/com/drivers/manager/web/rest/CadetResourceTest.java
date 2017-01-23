package com.drivers.manager.web.rest;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* CadetResource Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ�� 5, 2016</pre> 
* @version 1.0 
*/ 
public class CadetResourceTest {
    private static final String upload_dir = "E:\\code\\idea_workspace\\medal\\project\\drivers\\drivers-manager\\src\\main\\webapp\\upload\\cadet\\";
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testInputstreamtofile() throws Exception {
        String fileName = "E:\\项目\\驾校\\驾校登记表新_20161005.xlsx";
        CadetResource  cadetResource = new CadetResource();
        cadetResource.saveExcelData(fileName);
    }

} 
