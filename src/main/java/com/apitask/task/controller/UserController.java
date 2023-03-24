package com.apitask.task.controller;
import com.apitask.task.model.User;
import com.apitask.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{username}")
    User getUser(@PathVariable String username) {
        return userRepository.findById(username).orElseThrow();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/users/{username}")
    User updateUser(@RequestBody User user, @PathVariable String username) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{username}")
    void deleteUser(@PathVariable String username) {
        User toBeDeleted = userRepository.findById(username).orElseThrow();
        userRepository.delete(toBeDeleted);
    }
}
