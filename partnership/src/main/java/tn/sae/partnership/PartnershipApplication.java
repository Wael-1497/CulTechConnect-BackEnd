package tn.sae.partnership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PartnershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnershipApplication.class, args);
	}

}
