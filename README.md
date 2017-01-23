# 环境的搭建
## 搭建好java开发环境
jdk1.8,maven,git,ide,mysql5.6,github帐号等
## git克隆代码
````
 仓库: https://git.oschina.net/jinjun/medal.git 
 ```
## ide导入maven项目

## 运行maven命令
```
 maven clean install
```
## 搭建数据库环境
```
IP: 120.76.53.46  
用户名: root  
密码: 123456  
```
说明: 暂时可以直接从服务器克隆整个数据库
## 修改项目的数据库配置信息
```
src/main/resources/config/application-dev.yml
```
## 启动服务:
找到服务启动类(如: com.drivers.WeixinApplication),然后运行服务启动类的main方法
## 访问首页



# 项目开发流程
## 切换git分支到develop
## 编码
## 调试
## 提交代码




# 服务部署流程
## 合并develop分支到master分支
## 打包服务
将路径切到指定的服务根路径,然后使用maven执行下面命令:  
```
clean package spring-boot:repackage -P prod -e
```
## 上传服务到服务器
```
IP: 120.76.53.46  
用户名: root  
密码: Ruida@123   
```
使用FTP工具,上传到指定文件夹(/home/drvier)
## 启动服务
将路径切到指定文件夹,使用shell执行下面命令:  
```
nohup java -jar xxx.jar --spring.profiles.active=prod &
```
## 查看服务启动日志
将路径切到指定文件夹,使用shell执行下面命令:  
```
ps -ef|grep xxx.jar
```
## 访问首页



# 项目模块描述:
```
|medal
   |common
        |medal-common-utils: 普通工具类
        | medal-poi: excel工具类
        | medal-mybatis2: mybatis底层封装
        | medal-weixin: 微信开发底层封装
   |project
        |drivers
             |drivers-entity: 实体
             |drivers-dao: 数据层
             |drivers-router: API
             |drivers-manager: 驾校后台管理系统
             |drivers-weixin: 驾校微信端
   |tool
        | 项目的辅助小组件(辅助工具)
        
```     
        
        

# 包结构描述:
```
|java
    |com
        |drivers
            |服务名
                |config:配置信息
                |service: 业务逻辑层
                | util: 本业务相关的工具包
                | web: 控制层
            |XxxApplication: 服务启动类
|resources : 属性文件
|webapp
    |css
    |fonts
    |images
    |js
    |plugins
    |WEB-INF
        |views
            |xx.jsp
    |favicon.ico
```