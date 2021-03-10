# library-fast
图书管理系统

具有如下特点

友好的代码结构及注释，便于阅读及二次开发

实现前后端分离，通过token进行数据交互，前端再也不用关注后端技术

灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求

页面交互使用Vue2.x，极大的提高了开发效率

引入API模板，根据token作为登录令牌，极大的方便了APP接口开发

引入Hibernate Validator校验框架，轻松实现后端校验

引入swagger文档支持，方便编写API接口文档 

项目结构
library-fast
├─db  项目SQL语句
│
├─common 公共模块
│  ├─aspect 系统日志
│  ├─exception 异常处理
│  ├─validator 后台校验
│  └─xss XSS过滤
│ 
├─config 配置信息
│ 
├─modules 功能模块
│  ├─library 图书管理模块
│  ├─oss 文件服务模块
│  └─sys 权限模块
│ 
├─libraryApplication 项目启动类
│  
├──resources 
│  ├─mapper SQL对应的XML文件
│  └─static 静态资源

技术选型：

核心框架：Spring Boot 2.1
安全框架：Apache Shiro 1.4
视图框架：Spring MVC 5.0
持久层框架：MyBatis 3.3
数据库连接池：Druid 1.0
日志管理：SLF4J 1.7、Log4j
页面交互：Vue2.x 
后端部署

通过git下载源码
https://github.com/xushifu/library-fast.git
idea、eclipse需安装lombok插件，不然会提示找不到entity的get set方法
创建数据库library_fast，数据库编码为UTF-8
执行db/mysql.sql文件，初始化数据
修改application-dev.yml，更新MySQL账号和密码
Eclipse、IDEA运行libraryApplication.java，则可启动项目
Swagger文档路径：http://localhost:8080/library-fast/swagger/index.html
Swagger注解路径：http://localhost:8080/library-fast/swagger-ui.html

前端部署

本项目是前后端分离的，还需要部署前端，才能运行起来
前端下载地址：https://github.com/xushifu/library-fast-vue
安装npm 执行 npm  install  后执行  npm里的 dev就可以了。
前端部署完毕，就可以访问项目了，账号：admin，密码：admin

