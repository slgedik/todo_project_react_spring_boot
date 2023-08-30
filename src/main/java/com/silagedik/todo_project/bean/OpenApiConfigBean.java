package com.silagedik.todo_project.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfigBean {

    public OpenAPI openAPIMethod(){
        return new OpenAPI()
                .info(
                        new Info()
                                .description("blog tanımlama44")
                                .version("v1")
                                .contact(new Contact().email("slgedik42@gmail.com").url("url"))
                                .title("title 44")
                                .termsOfService("Software Inc")
                                .license(new License().url("http://www.").name("name")));
    }
}
