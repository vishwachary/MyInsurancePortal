package org.example.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyInsurancePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyInsurancePortalApplication.class, args);
    }

}
