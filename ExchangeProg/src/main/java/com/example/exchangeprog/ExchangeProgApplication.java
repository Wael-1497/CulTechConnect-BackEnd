package com.example.exchangeprog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@EnableFeignClients
@SpringBootApplication
public class ExchangeProgApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeProgApplication.class, args);
    }

}
