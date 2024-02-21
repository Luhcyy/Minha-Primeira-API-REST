package dio.myfirstwebapi.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contato() {
        return new Contact(
            "Lucas Assis",
            "https://www.linkedin.com/in/lucas-luiz-assis-609a3a205/",
            "lucas.luiz.assis12@gmail.com"
        );
    }

    private ApiInfo informacoesApi(){
    return new ApiInfoBuilder()
            .title("Title - Minha Primeira REST API")
            .description("API exemplo de uso de SpringBoot REST API")
            .version("1.0")
            .termsOfServiceUrl("Termo de uso: Open Source")
            .license("Licença - Sua Empresa")
            .licenseUrl("http://www.seusite.com.br")
            .contact(this.contato())
            .build(); // Call build() on the ApiInfoBuilder instance


    }

@Bean
public Docket detalheApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("dio.myfirstwebapi.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(informacoesApi()) // Use the informacoesApi method to get the ApiInfo object
            .consumes(new HashSet<String>(Arrays.asList("application/json")))
            .produces(new HashSet<String>(Arrays.asList("application/json")));
}

}
