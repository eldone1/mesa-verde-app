package com.cibertec.mesaverde.infrastructure.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Mesa Verde API",
        description = "API documentation for Mesa Verde application",
        termsOfService = "https://mesaverde.org/terms",     //Terminos de servicio
        version = "1.0.0", 
        contact = @Contact(
            name = "Mesa Verde Support",
            url = "https://mesaverde.org/support",
            email = "diego.dme966@gmail.com"),
        license = @License(
            name = "Standard License Mesa Verde",
            url = "http://www.mesaverde.org/licenses/LICENSE-2.0")
    ),
    servers = {
        @Server(
            url = "http://localhost:8080",
            description = "Local server"
        ),
    }
)
public class SwaggerConfig {

}
