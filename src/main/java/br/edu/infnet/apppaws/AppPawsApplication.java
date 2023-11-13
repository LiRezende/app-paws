package br.edu.infnet.apppaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppPawsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPawsApplication.class, args);
	}

}
