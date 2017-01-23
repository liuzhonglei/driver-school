package com.drivers.weixin.service.impl;

import com.drivers.entity.School;
import com.drivers.router.service.SchoolService;
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
public class AddrClickHandle implements ClickHandle{
    @Autowired
    private WeixinProperties weixinProperties;
    @Autowired
    private SchoolService schoolService;

    @Override
    public BaseMessageResp handle(Map<String,String> requestMap){
        NewsMessageResp newsMessage = new NewsMessageResp();

        Response<School> response = new Response<>();
        schoolService.findAll(response);
        School school = response.getContent();

        List<Article> articleList = new ArrayList<>();

        Article article = new Article();
        article.setTitle("眉山瑞达在这里等着您");
        StringBuilder sb = new StringBuilder();
        if (null != school){
            sb.append("驾校地址: " + school.getAddr());
        }else {
            sb.append("对不起,暂时没有公布驾校地址信息");
        }
        article.setDescription(sb.toString());
        article.setPicUrl(weixinProperties.getServerConfig().getUrl() + "images/school_addr.jpg");
        article.setUrl(weixinProperties.getServerConfig().getUrl() + "addr.html");
        articleList.add(article);
        // 设置图文消息个数
        newsMessage.setArticleCount(articleList.size());
        // 设置图文消息包含的图文集合
        newsMessage.setArticles(articleList);
        return  newsMessage;
    }
}
