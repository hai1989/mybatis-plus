package com.mybatis.mybatisplus.demo1.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Program:       demo1
 * package        com.mybatis.mybatisplus.demo1.config
 * ClassName:     MybatisPlusConfig
 * Description:   This is  a  class!
 * Date:          Created in  2019/7/3 14:43
 * Author         gaohaijiang
 * Version        V1.0.0
 */
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
