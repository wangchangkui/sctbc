package com.sctbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableOpenApi
@SpringBootApplication
public class SctbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SctbcApplication.class, args);
    }

}
