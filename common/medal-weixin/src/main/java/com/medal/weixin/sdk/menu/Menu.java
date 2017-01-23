package com.medal.weixin.sdk.menu;

import lombok.Data;

/**
 * 菜单
 *{
 "button":[
 {
 "type":"click",
 "name":"今日歌曲",
 "key":"V1001_TODAY_MUSIC"
 },
 {
 "name":"菜单",
 "sub_button":[
 {
 "type":"view",
 "name":"搜索",
 "url":"http://www.soso.com/"
 },
 {
 "type":"view",
 "name":"视频",
 "url":"http://v.qq.com/"
 },
 {
 "type":"click",
 "name":"赞一下我们",
 "key":"V1001_GOOD"
 }]
 }]
 }
 * Created by xhuji on 2016/9/3.
 */
@Data
public class Menu {

    private Button[] button;

}
