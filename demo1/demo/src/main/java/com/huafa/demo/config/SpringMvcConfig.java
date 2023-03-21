/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.huafa.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import jdk.internal.icu.util.CodePointTrie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 解决跨域问题
 **/
@Configuration
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    // http://localhost:8081/root/layui/layui.js

    /* 自定义jackson 消息序列化 */

    /**
     * 增加字符串转日期的功能
     */
    @PostConstruct
    public void initEditableValidation() {
    }

    /* 增加ajax跨域访问支持 */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**").allowedMethods("GET", "POST").allowedOrigins("*")
                .allowedHeaders("*");
    }

    // 添加protobuf支持，需要client指定accept-type：application/x-protobuf
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.TEXT_PLAIN);
        list.add(MediaType.TEXT_HTML);
        list.add(MediaType.TEXT_MARKDOWN);
        stringConverter.setSupportedMediaTypes(list);

        FastJsonHttpMessageConverter fjConervter = new FastJsonHttpMessageConverter();
        FastJsonConfig fjConfig = new FastJsonConfig();
        fjConfig.setDateFormat("yyyy-MM-dd");
        fjConfig.setCharset(Charset.forName("UTF-8"));
        fjConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteNullListAsEmpty);
        fjConervter.setFastJsonConfig(fjConfig);
        converters.add(0,fjConervter);

//        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
//        xmlConverter.setDefaultCharset(Charset.forName("utf-8"));
//        List<MediaType> list2 = new ArrayList<MediaType>();
//        list2.add(MediaType.APPLICATION_XML);
//        xmlConverter.setSupportedMediaTypes(list2);
//        converters.add(0, stringConverter);
//        converters.add(0, xmlConverter);
    }

    /* 忽略url大小写 */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
    }

    //// 访问静态资源 http://localhost:8081/root/layui/layui.js
    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // registry.addResourceHandler("/root/**").addResourceLocations("classpath:/static/root");
    // //registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    // registry.addResourceHandler("swagger-ui.html")
    // .addResourceLocations("classpath:/META-INF/resources/");
    // registry.addResourceHandler("/webjars/**")
    // .addResourceLocations("classpath:/META-INF/resources/webjars/");
    // super.addResourceHandlers(registry);
    // }

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");


        super.addResourceHandlers(registry);
    }

    /**
     * 配置servlet处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {

        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".html");
        registry.viewResolver(viewResolver);
        // super.configureViewResolvers(registry);
    }

}