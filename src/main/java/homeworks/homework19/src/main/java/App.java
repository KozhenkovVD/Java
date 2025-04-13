import repository.CustomerRepository;
import repository.OrderRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.OrderRepositoryImpl;

public class App {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl();
        System.out.println(customerRepository.findAll());
        System.out.println(customerRepository.findById(7));
        //customerRepository.deleteAll();
        System.out.println(orderRepository.findAll());
        System.out.println(orderRepository.findById(4));

    }
}
