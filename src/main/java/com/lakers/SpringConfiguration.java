package com.lakers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: panyusheng
 * @Date: 2020/5/14 23:19
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.lakers")
@Import({JdbcConfig.class})
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
}
