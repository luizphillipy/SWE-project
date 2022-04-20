package edu.miu.eshop.controller;


import edu.miu.eshop.model.Customer;
import edu.miu.eshop.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"api", "api/customers"})
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = {"/login"})
    public Customer login(@RequestBody Customer user) {
        return customerService.login(user.getEmail(), user.getPassword());
    }

}
