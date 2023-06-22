package com.dibros.imagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dibros")
public class ImagemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImagemApplication.class, args);
    }

}

