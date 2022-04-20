package edu.miu.eshop.service.implementation;

import edu.miu.eshop.model.Customer;
import edu.miu.eshop.repository.CustomerRepository;
import edu.miu.eshop.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer login(String email, String password) {
        return customerRepository
                .findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst().get();
    }

    @Override
    public Customer signup(Customer user) {
        return customerRepository.save(user);
    }
}
