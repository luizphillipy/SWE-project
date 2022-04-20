package edu.miu.eshop.service;

import edu.miu.eshop.model.User;

public interface UserService {
    User login(String email, String password);
    User signup(User user);
}
