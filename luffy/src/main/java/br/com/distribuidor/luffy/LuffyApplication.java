package br.com.distribuidor.luffy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LuffyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuffyApplication.class, args);
	}

}
