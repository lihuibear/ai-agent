package com.lihui.aiagent.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @version v1.0.0
 * @belongsProject: feng-ai-agent
 * @belongsPackage: com.qcdfz.fengaiagent.config
 * @author: fgh
 * @description: 多数据源配置类
 * @createTime: 2025-05-10 12:14
 */
@Configuration
public class DataSourceConfig {
    /**
     * 绑定并创建 MySQL 数据源
     */
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mysqlProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource mysqlDataSource() {
        return mysqlProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    /**
     * MySQL 上下文的 JdbcTemplate，其他组件默认注入
     */
    @Bean
    @Primary
    public JdbcTemplate mysqlJdbcTemplate(
            @Qualifier("mysqlDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    /**
     * 绑定并创建 PostgreSQL 数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource.postgres")
    public DataSourceProperties postgresProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresDataSource() {
        return postgresProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    /**
     * PostgreSQL 专用的 JdbcTemplate，供 PgVectorStore 使用
     */
    @Bean
    public JdbcTemplate postgresJdbcTemplate(
            @Qualifier("postgresDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
