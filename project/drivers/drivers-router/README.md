# API:文档：
 http://localhost:8080/swagger-ui.html
# 监控相关网页
## javaMelody:
http://127.0.0.1:8080/monitoring
## metrics ：
## javasimon
http://127.0.0.1:8080/javasimon

## 数据源：
 http://127.0.0.1:8080/druid/login.html
 
## 异常监控 服务器地址：
 http://www.bcyskj.com:8080/stackhunter
 
 # 如何打包
 mvn clean package -Dmaven.test.skip=true -P prod -e
 
 # 启动
 java -jar xxx.jar --spring.profiles.active=prod
 
 java -Dspring.profiles.active=profileName -jar targetfile.war
 
  mvnw spring-boot:run -Drun.profiles=profileName,profileName2