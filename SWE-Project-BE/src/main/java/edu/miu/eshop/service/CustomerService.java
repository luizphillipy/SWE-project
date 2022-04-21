package edu.miu.eshop.service;

import edu.miu.eshop.model.Customer;

public interface CustomerService {
    Customer login(String email, String password);
    Customer signup(Customer user);
}
