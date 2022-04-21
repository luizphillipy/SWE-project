package edu.miu.eshop.controller;

import edu.miu.eshop.model.User;
import edu.miu.eshop.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"api", "api/users"})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = {"/login"})
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @PostMapping(value = {"/signup"})
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }
}
