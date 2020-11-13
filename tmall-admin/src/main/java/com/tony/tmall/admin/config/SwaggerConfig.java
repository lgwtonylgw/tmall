package com.tony.tmall.admin.config;

import com.tony.tmall.common.config.BaseSwaggerConfig;
import com.tony.tmall.common.model.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by tony on 2020/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.tony.tmall.controller")
                .title("tmall后台系统")
                .description("tmall后台相关接口文档")
                .contactName("tony")
                .version("1.0.0")
                .enableSecurity(true)
                .build();
    }
}
