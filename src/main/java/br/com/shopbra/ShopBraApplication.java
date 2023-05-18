package br.com.shopbra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAutoConfiguration
@EnableCaching
@EnableAsync
@SpringBootApplication
public class ShopBraApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopBraApplication.class, args);
	}

}
