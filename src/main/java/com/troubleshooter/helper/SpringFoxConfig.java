package com.troubleshooter.helper;

import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
//@EnableWebMvc
@EnableSwagger2
//@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(appinfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.troubleshooter.helper.controller"))
                //Predicate.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo appinfo(){
        return new ApiInfoBuilder().title("Basic Profile API")
                .description("This API is just a basic template for implementing new features with")
                .version("V1.0").build();
    }

}
