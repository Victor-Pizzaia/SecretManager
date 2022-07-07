package org.pizzaia.secretManager;

import org.pizzaia.secretManager.model.Owner;
import org.pizzaia.secretManager.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecretManagerApplication {// implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecretManagerApplication.class, args);
    }

    /* @Autowired
    OwnerService ownerService;

    @Override
    public void run(String... args) {
        var user = new Owner(1, "Victor", "abc123", "Victor_pizzaia@hotmail.com", "Victor", "Pizzaia");
        System.out.println(ownerService.saveOrUpdateOwner(user));
    }*/
}
