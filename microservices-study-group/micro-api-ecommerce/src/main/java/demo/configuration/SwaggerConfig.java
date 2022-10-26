package demo.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger cinfiguration class
 * <p>
 * The Swagger UI will be available ar http://localhost:8080/swagger-ui/
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData()).select()
                                                      .apis(RequestHandlerSelectors.any())
                                                      .paths(regex(".*" + "/api" + "/.*")).build();
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Spring Boot RESTFull API")
                                   .description("Spring Boot RESTfull WEB-API").version("1.0.0")
                                   .license("Apache License Version 2.0")
                                   .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                                   .build();
    }
}
