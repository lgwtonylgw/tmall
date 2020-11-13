package com.tony.tmall.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by tony on 2020/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.tony.tmall.dao"})
public class MyBatisConfig {
}
