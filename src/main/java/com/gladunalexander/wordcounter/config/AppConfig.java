package com.gladunalexander.wordcounter.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by user on 08/09/2017.
 */

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{

    @Bean
    public JavaSparkContext javaSparkContext(){
        SparkConf sparkConf = new SparkConf().setAppName("wordCounter").setMaster("local[*]");
        return new JavaSparkContext(sparkConf);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/**").addResourceLocations("classpath:/");
    }
}
