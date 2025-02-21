package com.practice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Documentacion de Api Microservicio de Usuarios",
                description = "Documentacion de Api Microservicio de  Usuarios",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "Local Server",
                        url = "http://localhost:8080/api/v1/user"
                )
        }
)
public class SwaggerConfig {

}