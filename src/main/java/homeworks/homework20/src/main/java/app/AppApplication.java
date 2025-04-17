package app;

import app.model.Customer;
import app.repository.CustomerRepository;
import app.repository.impl.CustomerRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AppApplication {




	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}
