package com.drivers.weixin.service.impl;

import com.drivers.entity.School;
import com.drivers.router.service.SchoolService;
import com.drivers.router.web.response.base.Response;
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
public class ContactClickHandle implements ClickHandle{
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
        article.setTitle("瑞达欢迎您的咨询");
        if (null != school){
            article.setDescription("电话号码: " + school.getMobile() + " 联系人:" + school.getAdministrators());
        }else {
            article.setDescription("电话号码: " + "未知" + " 联系人:" + "未知" );
        }
        article.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
        article.setUrl("http://baidu.com/");
        articleList.add(article);
        // 设置图文消息个数
        newsMessage.setArticleCount(articleList.size());
        // 设置图文消息包含的图文集合
        newsMessage.setArticles(articleList);
        return  newsMessage;
    }
}
