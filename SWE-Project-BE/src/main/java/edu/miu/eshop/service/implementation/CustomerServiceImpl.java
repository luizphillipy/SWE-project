package edu.miu.eshop.service.implementation;

import edu.miu.eshop.model.Customer;
import edu.miu.eshop.repository.CustomerRepository;
import edu.miu.eshop.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository CustomerRepository;

    public CustomerServiceImpl(CustomerRepository CustomerRepository) {
        this.CustomerRepository = CustomerRepository;
    }

    @Override
    public Customer login(String email, String password) {
        return CustomerRepository
                .findAll()
                .stream()
                .filter(Customer -> Customer.getEmail().equals(email) && Customer.getPassword().equals(password))
                .findFirst()
                .orElseGet(() -> null);
    }

    @Override
    public Customer signup(Customer Customer) {
        if (CustomerRepository.findAll().stream().anyMatch(u -> u.getEmail().equals(Customer.getEmail()))) {
            return null;
        }
        return CustomerRepository.save(Customer);

    }
}
