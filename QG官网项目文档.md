# QG官网项目文档

## 一.总体架构

本项目总体上使用JavaEE三层架构模型，整体分为登陆，
关于QG，我们，成员，项目，荣誉，专栏等模块。
前端使用html,css,js构建网页,后台服务器使用Java开发。
主要负责QG官网后台服务器和QG官网后台管理系统的开发，
实现对QG官网数据的保存，处理，更新。
对于官网页面的所有数据实现CURD,并且对于荣誉页面的数据实现excel文档的导入导出。

## 二.后台架构

### 2.1 项目开发环境
jdk版本：1.8
tomcat版本：9.0
mysql版本：5.7
spring版本：5.0.2

### 2.2 数据库设计
数据库总共16张表。

### 2.3 业务层架构
业务层由对官网数据进行增删改查处理的service和额外的提供
excel文档导入导出功能的excelservice,
提供文件上传功能的uploadservice组成。
除了上传文件和导入导出excel的功能之外，
每个service的功能都是增删改查。

### 2.4 接口数据定义

#### 2.4.1 请求格式
http://主机名：端口/功能模块/操作
#### 2.4.2 请求参数
formdata格式或者json格式
###### 示例：request
```http request
POST  /honor/update  HTTP/1.1
Host: www.cxkball.club:2333
Content-Type:application/json

{
"title":"荣誉标题",
"description":"描述信息",
"date":"2019-01-01",
"id":"35"
}

```
#### 2.4.3 响应数据
响应数据由三个部分组成，格式为json。
三个部分分别为：
###### 状态码(status)
描述此次处理的结果，200表示成功，500表示服务器
发生了异常，无法处理此次请求，400~499之间
表示因为请求参数不正确(比如id对应的数据不存在)，
或者业务上的限制条件(比如用户名的格式不正确)，
等原因，服务器拒绝执行此次请求。
在同一个请求路径下，状态码不能重复，分别标识不同的请求结果。

###### 描述信息(message)
关于此次请求结果的文字描述，比如“密码错误”，“图片格式不正确”等。
不同的状态码配有不同的描述信息，描述信息可以修改，所以前端应该使用status判断
响应的状态。
###### 响应数据(data)
对于此次请求，服务器返回的数据，比如分页查询成员数据之后，返回json格式的成员数组，
这些成员数据就放置在data中。
###### 示例：response
```json
{
"status":200,
"message":"您的请求成功！",
"data":{
  "id":35,"uuid":null,
  "title":"荣誉标题",
  "date":"2019-01-01",
  "images":null,
  "gmtCreate":null,
  "gmtModified":null,
  "description":"描述信息",
  },
}

```
### 2.4.4 项目配置文件说明
- dataSource.properties:数据库连接配置
- applicationContext.xml：spring框架配置
- springmvc.xml:springmvc框架配置
- generatorConfig.xml:mybatis逆向工程插件配置
- qgConfig.properties:项目的一些路径变量配置
- log4j.properties:日志框架配置
- SqlMapConfig.xml mybatis框架配置(仅测试时有效，部署tomcat之后由spring接管)
## 三.前端架构

