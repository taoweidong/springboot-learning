# SpringBoot学习笔记-整合Mybatis

# 学习计划

- 使用generateConfig生成Mapper以及Pojo
- 实现基于Mybatis的CRUD功能
- 整合mybatis-pagehelper实现分页
- 自定义mapper的实现
- 慕课网源码：https://github.com/leechenxiang/imooc-springboot-starter
- https://github.com/abel533/MyBatis-Spring-Boot



# 使用generateConfig生成Mapper以及Pojo

> 使用org.mybatis.generator来生成Mapper和数据库表对应的pojo类，加快开发速度。

## 创建学习工程：SpringBoot-mybatis

![1524636585351](C:\Users\Taowd\AppData\Local\Temp\1524636585351.png)

## 添加依赖

```xml
   <!-- Spring Boot Mybatis 依赖 -->
        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>
        <!--mapper-->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
            <version>1.1.4</version>
        </dependency>
        <!--pagehelper-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.1</version>
        </dependency>

        <!-- Mybatis Generator -->
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.3.2</version>
            <scope>compile</scope>
            <optional>true</optional>
        </dependency>

        <!-- MySQL 连接驱动依赖 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.21</version>
        </dependency>
```

## 添加Generate的Maven插件

```xml
  <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.2</version>
                <configuration>
                    <configurationFile>${basedir}/src/main/resources/generatorConfig.xml</configurationFile>
                    <overwrite>true</overwrite>
                    <verbose>true</verbose>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>5.1.21</version>
                    </dependency>
                    <dependency>
                        <groupId>tk.mybatis</groupId>
                        <artifactId>mapper</artifactId>
                        <version>3.3.6</version>
                    </dependency>
                </dependencies>
            </plugin>
```

## 配置generatorConfig.xml文件(用于Generate生成pojo和mapper)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <context id="MysqlContext" targetRuntime="MyBatis3Simple" defaultModelType="flat">
        <property name="beginningDelimiter" value="`"/>
        <property name="endingDelimiter" value="`"/>
        <!-- 为了防止生成的代码中有很多注释，比较难看，加入下面的配置控制 -->
        <!--   <property name="suppressAllComments" value="true"/>
           <property name="suppressDate" value="true"/>-->

        <!--继承自己的MyMapper，内含基本的方法-->
        <plugin type="tk.mybatis.mapper.generator.MapperPlugin">
            <property name="mappers" value="generate.MyMapper"/>
        </plugin>

        <!--数据库配置文件-->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://127.0.0.1:3306/test"
                        userId="root"
                        password="root">
        </jdbcConnection>

        <!-- 对于生成的pojo所在包 -->
        <javaModelGenerator targetPackage="com.taowd.pojo" targetProject="src/main/java"/>

        <!-- 对于生成的mapper所在目录 -->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources"/>

        <!-- 配置mapper对应的java映射接口的位置 -->
        <javaClientGenerator targetPackage="com.taowd.mapper" targetProject="src/main/java"
                             type="XMLMAPPER"/>

        <!--需要生成pojo的数据表-->
        <table tableName="user"></table>
        <table tableName="sys_user"></table>

    </context>
</generatorConfiguration>
```

## 自定义Mapper接口类

> **该接口不能被SpringBoot Scan扫描到，否则会出错**

```java
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
```

## 执行插件，生成代码

![1524671729610](C:\Users\Taowd\AppData\Local\Temp\1524671729610.png)

## 最终工程的代码结构

![1524671787310](C:\Users\Taowd\AppData\Local\Temp\1524671787310.png)

