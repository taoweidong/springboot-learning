> SpringBoot第一个项目 HelloWorld 

# 什么是Spring boot？

Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。

- 它是Spring的升级版，Spring容器能做到的事情，它都能做到，而且更简便，从配置形式上来说，SpringBoot完全抛弃了繁琐的XML文件配置方式，而是替代性地用注解方式来实现，虽然本质来说，是差不多的（类似包扫描，注解扫描，类加载之类）。
- SpringBoot集成的插件更多，从而使用很多服务，都只是引入一个依赖，几个注解和Java类就可以用了，具体的参考相关手册。
- 在Web应用开发这一块，之前的应用一般来说是打包成war包，再发布到相关服务器容器下（例如Tomcat），虽然SpringBoot也可以这么做，但在SpringBoot下更常见的形式是将SpringBoot应用打包成可执行jar包文件。之所以这么做，源于你可以直接将SpringBoot应用看成是一个Java Application，其Web应用可以没有webapp目录（更不用说web.xml了），它推荐使用html页面，并将其作为静态资源使用。

# SpringBoot特点(为什么用它)

- 独立运行的Spring项目
- 内嵌Servlet容器
- 提供starter简化Maven配置
- 自动配置Spring 
- 准生产的应用监控
- 无代码生成和xml配置


# Spring Boot特性理解

- 为基于Spring的开发提供更快的入门体验
- 开箱即用，没有代码生成，也无需XML配置。同时也可以修改默认值来满足特定的需求。
- 提供了一些大型项目中常见的非功能特性，如嵌入式服务器、安全、指标，健康检测、外部配置等。
- Spring Boot并不是对Spring功能上的增强，而是提供了一种快速使用Spring的方式。   



# SpringBoot的缺点

- 引入许多自己不需要的jar包，导致项目臃肿

# Spring Cloud 概述

SpringCloud是基于SpringBoot的一整套实现微服务的框架。他提供了微服务开发所需的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等组件。最重要的是跟Spring Boot框架一起使用的话，会让你开发微服务架构的云服务非常好的方便。

# Spring Boot与Spring Cloud关系

Spring boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务，Spring Cloud是一个基于Spring Boot实现的云应用开发工具；Spring boot专注于快速、方便集成的单个个体，Spring Cloud是关注全局的服务治理框架；Spring Boot使用了默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置，Spring Cloud很大的一部分是基于Spring Boot来实现。
Spring boot可以离开Spring Cloud独立使用开发项目，但是Spring Cloud离不开Spring Boot，属于依赖的关系。

    spring -> spring boot > spring cloud 这样的关系。



# 前提条件

- Java基础
- 了解Maven
- 了解SpringMVC,Spring框架的使用
- Mybatis,Hibernate等的使用
- 熟悉STS,Eclipse,Idea等开发工具的使用


# 学习软件

- apache-maven-3.5.0（Maven版本）
- nexus-2.14.8-01-bundle(Maven私库)
- jdk1.8（jdk版本）
- IntelliJ IDEA 2017.3.2 x64（开发工具）
- Lomback（Idea插件 代码助手 简化代码）
- GitHub（代码仓库）


# 学习思路

> 使用Maven进行项目管理，创建顶级的父工程管理项目jar包版本等信息，使用目前最流行的Java开发工具Idea工具进行开发；再父工程下创建相应的子项目进行学习，每个学习点创建一个工程，完全分离，这样便于后期查漏补缺。


# 学习计划

- SpringBoot-HelloWorld：创建项目结构，发布GitHub仓库，创建第一个HelloWorld程序，并封装返回JSON对象的功能
- SpringBoot-FastJson：通过相关配置将SpringBoot中的JSON的默认解析方式修改为FastJson
- SpringBoot-Swagger：SpringBoot整合Swagger2项目
- SpringBoot-thymeleaf: 学习SpringBoot整合Thymleaf技术
- SpringBoot-Exception: 学习SpringBoot异常处理功能
- SpringBoot-Mybatis: 学习SpringBoot整合MyBatis
- SpringBoot-Interceptor: 学习SpringBoot整合拦截器
- SpringBoot-StudentManager: 完成SpringBoot的一个小项目
- SpringBoot-Redis :学习SpringBoot整合Redis功能
- SpringBoot-task: 学习SpringBoot整合定时任务功能   -- 待完善
- SpringBoot-AsyncTask: 学习SpringBoot整合异步任务功能 -- 待完善
- commmon-utils：工具类组件，提供给当前所有项目使用，同时作为工具类的整理
- SpringBoot-config：SpringBoot配置文件加载顺序测试

# 参考资料
- 优质GitHub项目：https://github.com/smltq/spring-boot-demo
    - 码云仓库：https://gitee.com/tqlin/spring-boot-demo.git
    - GitHub仓库：https://github.com/smltq/spring-boot-demo.git

