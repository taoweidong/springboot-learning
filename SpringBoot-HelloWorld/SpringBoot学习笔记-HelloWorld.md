# 本节要点
- 使用Maven创建工程结构

![](https://i.imgur.com/owoA5OC.png)

- 编写控制器，启动访问

![](https://i.imgur.com/hDku22Y.png)

- 访问：[http://127.0.0.1:8090/getUser](http://127.0.0.1:8090/getUser)

![](https://i.imgur.com/Bojo9RN.png)

# 2020年2月15日
以下注解的学习
- @ConfigurationProperties(prefix = "person")
- @PropertySource(value = {"classpath:person.properties"})
- @Configuration
- @ImportResource(value = {"classpath:beans.xml"})