package com.sahani.banking.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.persistence.Version;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@OpenAPIDefinition(
        info = @Info(
             title = "online banking",
               description = "its available 24 hrs",
                 termsOfService = "T&C",
                contact = @Contact(
                name = "Akhilesh Sahani",
                email ="akh@gmail.com"
                 ),
              license = @License(
                name = "Apache License, Version 2.0"
             ),
             version = "v2.0"

             ),
        servers =
                {
             @Server(
                description = "dev",
                url = "http://localhost:8080"
        ),
            @Server(
                    description = "test",
                    url = "http://localhost:8081"
            )

        }
)
public class BankConfig {


}

