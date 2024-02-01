package com.desafio.decrypto.msdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class
 */
@SpringBootApplication
public class MsDbApplication {
    /**
     * Main method
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(MsDbApplication.class, args);
        System.out.println("App up and running!");
    }
}
