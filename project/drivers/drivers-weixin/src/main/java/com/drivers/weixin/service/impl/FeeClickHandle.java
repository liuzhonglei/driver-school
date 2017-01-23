package com.drivers.weixin.service.impl;

import com.drivers.router.service.SchoolTuitionService;
import com.drivers.router.web.response.SchoolTuitionResp;
import com.drivers.router.web.response.base.Response;
import com.drivers.weixin.config.WeixinProperties;
import com.medal.weixin.sdk.message.response.Article;
import com.medal.weixin.sdk.message.response.NewsMessageResp;
import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import com.medal.weixin.sdk.service.ClickHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/10/22.
 */
@Service
@Transactional
@Slf4j
public class FeeClickHandle implements ClickHandle{
    @Autowired
    private SchoolTuitionService schoolTuitionService;
    @Autowired
    private WeixinProperties weixinProperties;

    @Override
    public BaseMessageResp handle(Map<String,String> requestMap){
        NewsMessageResp newsMessage = new NewsMessageResp();

        Response<SchoolTuitionResp> response = new Response<>();
        schoolTuitionService.findAllBySearch(response);
        SchoolTuitionResp schoolTuitionResp = response.getContent();
        List<Article> articleList = new ArrayList<>();
        Article article = new Article();
        article.setTitle("眉山瑞达驾校收费标准");
        StringBuilder sb = new StringBuilder();
        if (null != schoolTuitionResp){
            sb.append("驾驶车型:  " + "桑塔纳(C1)" + "\n");
            sb.append("班        型:  " + "普通班"  + "\n");
            sb.append("学车费用:  " + schoolTuitionResp.getTuition()  + "\n");
            sb.append("学车时间:  " + "星期一至星期五学车随到随学"  + "\n");
            sb.append("班型特点:  " + "价格便宜，适合非上班族"  + "");

        }else {
            sb.append("对不起,暂时没有公布费用信息");
        }
        article.setDescription(sb.toString());
        article.setPicUrl(weixinProperties.getServerConfig().getUrl() + "images/car.jpg");
        article.setUrl(weixinProperties.getServerConfig().getUrl() + "fee.html");
        articleList.add(article);
        // 设置图文消息个数
        newsMessage.setArticleCount(articleList.size());
        // 设置图文消息包含的图文集合
        newsMessage.setArticles(articleList);
        return  newsMessage;
    }
}
