package com.medal.tool.wiki.help;

import com.medal.tool.wiki.repository.TableWikiMapper;
import com.medal.tool.wiki.entity.TableWiki;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by xhuji on 2016/8/31.
 */
@Component
@Slf4j
public class WikiHelper {

    public static final String TABLE_SCHEMA = "drivers";

    @Autowired
    private TableWikiMapper tableWikiMapper;
    /**
     * 从数据库中读取指定表,生成wiki表字段描述
     * @param tableName
     * @param tableSchema
     * @return
     */
    public String createDbTableWiki(String tableName,String tableSchema){
        if(StringUtils.isBlank(tableSchema)){
            tableSchema = TABLE_SCHEMA;
        }
        //1 获取表字段
        List<TableWiki> tableWikiList = tableWikiMapper.findTableWikiByTableName(tableName,tableSchema);
//        System.out.println(tableWikiList);
        //2 解析表字段
        String text = paraeTable(tableWikiList);
        return text;
    }
    /**
     * 从数据库中读取指定表,生成wiki表字段描述,生成文件并打印到指定路径
     * @param tableName
     * @param tableSchema
     * @param outPath  输出路径,包含文件名与扩展
     */
    public void createDbTableWiki2File(String tableName,String tableSchema,String outPath){
        String text = createDbTableWiki(tableName,tableSchema);
        try {
            writeFile(text,outPath);
        } catch (IOException e) {
            log.error("createDbTableWiki error",e);
        }
    }

    /**
     * 从数据库中读取指定表,生成wiki表字段描述,生成文件并打印到指定路径
     * @param tableName
     * @param outPath  输出路径,包含文件名与扩展
     */
    public void createDbTableWiki2File(String tableName,String outPath){
        createDbTableWiki2File(tableName,null,outPath);
    }

    /**
     * 以文件方式输出
     * @param text
     * @throws IOException
     */
    private void writeFile(String text,String outPath) throws IOException {
        File outFile = new File(outPath);
        FileUtils.writeStringToFile(outFile,text);
    }

    private String paraeTable(List<TableWiki> tableWikiList){
        StringBuffer sb = new StringBuffer("|字段名称|数据类型|是否必需|备注|\n");
        sb.append("|-------|------|-----|------|\n");
        for (TableWiki tableWiki : tableWikiList){
            sb.append("|");
            sb.append(tableWiki.getColumnName());
            sb.append("|");
            sb.append(getJavaTpye(tableWiki.getColumnType()));
            sb.append("|");
            sb.append(getIsNullAble(tableWiki.getIsNullable()));
            sb.append("|");
            sb.append(getComment(tableWiki.getColumnComment()));
            sb.append("|\n");
        }
        return sb.toString();
    }

    private String getComment(String columnComment){
        String comment = StringUtils.replace(columnComment,"\n"," ");
        comment = StringUtils.replace(comment,"\r"," ");
        return comment;
    }

    private String getIsNullAble(String isNullAble){
        if("YES".equals(isNullAble)){
            return "否";
        }else{
            return "是";
        }
    }

    private String getJavaTpye(String dbType){
        if(StringUtils.contains(dbType,"bigint")
                || StringUtils.contains(dbType,"timestamp")){
            return "long";
        }
        if(StringUtils.contains(dbType,"int")) {
            return "int";
        }
        if(StringUtils.contains(dbType,"date")){
            return "Date";
        }
        if(StringUtils.contains(dbType,"varchar")){
            return "String";
        }
        if(StringUtils.contains(dbType,"decimal")){
            return "float";
        }
        return "";
    }
}
