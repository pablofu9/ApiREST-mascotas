package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Usuarios REST API",
                "Mi primera API REST.",
                "1.0",
                "http://www.pablo.es",
                new Contact("Juan", "www.juan.es", "juan@gmail.com"),
                "License of API", "LICENSE URL", Collections.emptyList());
    }

    /*
    Podrás ver que nos ha generado un path llamado /v2/api-docs,
    por lo que si los accedemos en el navegador (http://localhost:5001/v2/api-docs)
    podremos ver los metadatos del API generado por la librería springfox-swagger2:
     */

    /*
    Sin embargo, esta documentación no es para nada intuitiva,
     y es por ello que hemos instalado la librería springfox-swagger-ui,
     la cual toma esta metadata y crea la URL: http://localhost:5001/swagger-ui.html,
     la cual se ve así:
     */

}