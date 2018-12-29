# Kyrie Blog
## 个人博客系统
Kyrie Blog是由SpringBoot1.5 + MyBatis + Thymeleaf等技术实现的个人网站，如果觉得项目不错，请帮忙`Star`支持一下。
### 适用对象
* Spring Boot 初学者。该博客系统综合运用了作者发表的 《Spring Boot 入门》 系列的文章提及的知识内容，初学者可以阅读文章以及结合该项目学习。
* 与作者一样，使用 hexo 但苦于没有后台管理工具（界面）管理文章的写作者。该博客系统模仿 hexo 生成的访问路径，并支持 markdown 文件导入功能。
* 懵懂者。初次接触博客系统的人。
### 技术栈
#### 后端
* 核心框架：SpringBoot
* 持久层框架：MyBatis
* 模板框架：Thymeleaf
* 分页插件：PageHelper
* 缓存框架：Ehcache
* Markdown：Commonmark

#### 前端
* JS框架：Jquery
* CSS框架：Bootstrap
* 富文本编辑器：editor.md
* 文件上传：dropzone
* 弹框插件：sweetalert

#### 第三方
* 七牛云（文件上传）
* 百度统计

### 预览效果
#### 前端效果
![index](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/index.png)

![archives](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/archives.png)

![detail](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/detail.png)

![category](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/category.png)

![about](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/about.png)

#### 后端效果
![adminlogin](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/adminlogin.png)

![adminindex](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/adminindex.png)

![articlepublish](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/articlepublish.png)

![articlemanager](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/articlemanager.png)

![filemanager](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/filemanager.png)

![setting](http://caozongpeng.oss-cn-shenzhen.aliyuncs.com/image/blog/setting.png)

### 安装
下载源码，执行sql文件，然后修改application-dev.yml文件中连接数据库的用户名、密码。运行项目即可。

前端访问地址：http://localhost:8888

后台访问地址：http://localhost:8888/admin 用户名：admin 密码：123456

### 更新日志
2018-08-04发布第一个版本
