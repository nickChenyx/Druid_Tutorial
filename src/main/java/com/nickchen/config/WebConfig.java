package com.nickchen.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * @author nickChen
 * @create 2017-07-27 9:34.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    // Druid 多数据源配置
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    // 测试两个数据源是否配置正确
    @Bean
    public String a(){
        DataSource source1 = dataSourceOne();
        DataSource source2 = dataSourceTwo();
        return "a";
    }


}
