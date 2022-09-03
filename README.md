# 前端项目目录结构

项目入口：src/main.js，src/App.vue

package.json：项目基本配置，项目依赖，npm相关命令

vue.config.js：配置端口号

build目录：项目构建

src目录：主要写代码的地方

​	——api目录：定义接口的地址url

​	——assets目录：存放静态资源

​	——components目录：vue公共组件

​	——router目录：路由跳转，页面跳转，可以配置views中的页面跳转

​	——views目录：主体页面，

​	——utils目录：写一些常用工具

参考链接：https://blog.csdn.net/qq_40934129/article/details/126039160

# 如何在本地上启动项目

### 安装node.js和npm

参考链接：https://blog.csdn.net/qq_44625774/article/details/124090443（只用看下载与安装）

在terminal中输入**node -v**和**npm -v**命令查看是否完成安装

### 安装vue-cli

参考链接：https://blog.csdn.net/m0_67392661/article/details/123368325

terminal中输入**npm install vue-cli -g**

**vue list**查看安装是否成功

![屏幕截图 2022-09-04 062402](D:\Desktop\屏幕截图 2022-09-04 062402.png)

### 安装webpack

terminal输入**npm install webpack webpack-cli -g** 

### 安装vscode

### 启动项目

在vscode中进入到项目中，打开terminal，依次输入

**npm install**


**npm run dev**

项目成功启动

# demo项目使用说明
该项目源码地址https://github.com/antoine92190/vue-advanced-chat

该项目是一个在线聊天室的vue组件化工具，可以找到自己想要的功能（语音，发送消息，发送图片等等），并将代码直接粘贴到demo项目中，即可看到效果，具体的教程参考视频https://www.bilibili.com/video/BV1U3411r7nd?spm_id_from=333.337.search-card.all.click&vd_source=5eee84cb4f09a3c794199bfbfed84eed

demo项目的启动需要

**npm install**

**npm run dev**