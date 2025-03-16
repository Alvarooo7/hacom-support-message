package pe.hacom.service.support.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SupportHacomMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportHacomMessageApplication.class, args);
	}

}
