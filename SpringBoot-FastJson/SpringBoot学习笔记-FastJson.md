# Spring Boot使用FastJson解析JSON数据

> spring boot默认的json解析框架是jackson ,而目前比较流行的JSON解析框架是FastJson,
可以通过相关配置将SpringBoot中的JSON的默认解析方式修改为FastJson

# 步骤

- 创建SpringBoot项目
- 引入fastjson依赖库

   <!--FastJson依赖库-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.15</version>
    </dependency>

**注意：**官方文档说的1.2.10以后，会有两个方法支持HttpMessageconvert，一个是FastJsonHttpMessageConverter，支持4.2以下的版本，一个是FastJsonHttpMessageConverter4支持4.2以上的版本，具体有什么区别暂时没有深入研究。这里也就是说：低版本的就不支持了，所以这里最低要求就是1.2.10+。

- 创建配置类MyConfig继承WebMvcConfigurerAdapter，增加@Configuration注解

- 重写configureMessageConverters方法

	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        
		super.configureMessageConverters(converters);

        // 1、需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat
        );

        //3、在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);

        //4、将convert添加到converters当中.
        converters.add(fastConverter);
        
   		}



