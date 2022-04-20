package edu.miu.eshop.service.implementation;

import edu.miu.eshop.model.User;
import edu.miu.eshop.repository.UserRepository;
import edu.miu.eshop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String email, String password) {
        return userRepository
                .findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst().get();
    }

    @Override
    public User signup(User user) {
        return userRepository.save(user);
    }
}
