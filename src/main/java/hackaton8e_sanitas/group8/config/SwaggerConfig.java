package hackaton8e_sanitas.group8.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI Group8ApplicationOpenApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("Hackaton Sanitas & Somos F5 API")
                        .description("REST API built with Java/Spring Boot for managing users, medications and treatments. " +
                                "It implements a layered architecture with DTOs and mappers.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo 8 - Somos F5")));
    }
}
