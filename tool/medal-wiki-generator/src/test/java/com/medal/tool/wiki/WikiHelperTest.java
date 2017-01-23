package com.medal.tool.wiki;

import com.medal.tool.wiki.entity.TableWiki;
import com.medal.tool.wiki.help.WikiHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * WikiHelper Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 1, 2016</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WikiHelperTest {
    @Autowired
    private WikiHelper wikiHelper;

    /**
     * Method: createDbTableWiki(String tableName, String tableSchema)
     */
    @Test
    public void testCreateDbTableWiki() throws Exception {
        wikiHelper.createDbTableWiki2File("cadet","/Users/lb_pro/Desktop/trade_wiki.md");
    }

    /**
     * Method: createDbTableWiki2File(String tableName, String tableSchema, String outPath)
     */
    @Test
    public void testCreateDbTableWiki2FileForTableNameTableSchemaOutPath() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: createDbTableWiki2File(String tableName, String outPath)
     */
    @Test
    public void testCreateDbTableWiki2FileForTableNameOutPath() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: writeFile(String text, String outPath)
     */
    @Test
    public void testWriteFile() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = WikiHelper.getClass().getMethod("writeFile", String.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: paraeTable(List<TableWiki> tableWikiList)
     */
    @Test
    public void testParaeTable() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = WikiHelper.getClass().getMethod("paraeTable", List<TableWiki>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getComment(String columnComment)
     */
    @Test
    public void testGetComment() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = WikiHelper.getClass().getMethod("getComment", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getIsNullAble(String isNullAble)
     */
    @Test
    public void testGetIsNullAble() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = WikiHelper.getClass().getMethod("getIsNullAble", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getJavaTpye(String dbType)
     */
    @Test
    public void testGetJavaTpye() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = WikiHelper.getClass().getMethod("getJavaTpye", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
