package com.benchwarmers.grads.grizzlystoregoogleuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class GrizzlystoregoogleuserApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrizzlystoregoogleuserApplication.class, args);
    }

}