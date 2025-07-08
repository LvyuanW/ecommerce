package com.uoa.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NL4DB 后端接口文档")
                        .version("1.0.0")
                        .description("本项目用于研究“使用自然语言访问数据库（Natural Language Query for Databases）”，提供学生、教师、课程及其关联管理功能的 REST API。")
                        .contact(new Contact()
                                .name("WANG Lvyuan")
                                .email("Lvyuanw@gmail.com")
                                .url("https://lvyuanw.github.io/"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                );
    }
}
