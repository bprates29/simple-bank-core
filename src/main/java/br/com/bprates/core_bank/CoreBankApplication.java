package br.com.bprates.core_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoreBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreBankApplication.class, args);
	}

}
