> 此项目为spring boot2练习工程

## 工程目录
- /el : el表达式相关
- /swagger : 集成swagger
- /web : 集成servlet filter listener

## Spring Boot 更换 Banner
只需要在src/main/resources路径下新建一个banner.txt文件，banner.txt中填写好需要打印的字符串内容即可。
一般情况下，我们会借助第三方工具帮忙转化内容，如网站http://www.network-science.de/ascii/将文字转化成字符串，网站：http://www.degraeve.com/img2txt.php可以将图片转化成字符串。

## 使用xml配置
Spring boot 提倡零配置，即无xml配置，但是在实际中可能会有一些配置必须使用xml,这时我们可以通过`@ImportResource`注解来加载配置

## 指定使用特定的配置文件
`spring.profiles.active=xxx`

## 打印GC垃圾回收情况
在VM options里加上`-XX:+PrintGCDetails -Xmx256M -Xms256M `