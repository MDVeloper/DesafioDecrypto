package com.desafio.decrypto.msdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MsDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDbApplication.class, args);
		System.out.println("App up and running!");
	}

}
