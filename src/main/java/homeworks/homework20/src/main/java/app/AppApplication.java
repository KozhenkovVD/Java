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
//		CustomerRepository customerRepository = new CustomerRepositoryImpl();
//
//		OrderRepository orderRepository = new OrderRepositoryImpl();
//		System.out.println(customerRepository.findAll());
// 	System.out.println(customerRepository.findById(7));
////		customerRepository.deleteAll();
//		System.out.println(orderRepository.findAll());
//		System.out.println(orderRepository.findById(4));
	}

	public void run(String... args) throws RuntimeException {
		CustomerRepository customerRepository = new CustomerRepositoryImpl();
		Customer customer = new Customer("бонд", "джеймс");
		customerRepository.addCustomer(customer);

	}

}
