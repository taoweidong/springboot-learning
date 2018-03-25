package com.taowd.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Taowd
 * @date 2018/3/25 - 10:31
 * @Description
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    /**
     * 1、需要先定义一个 convert 转换消息的对象;
     * 2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
     * 3、在convert中添加配置信息.
     * 4、将convert添加到converters当中.
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        /*
         * 1、需要先定义一个 convert 转换消息的对象;
         * 2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
         * 3、在convert中添加配置信息.
         * 4、将convert添加到converters当中.
         *
         */

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

}
