package com.WebServicesProject.Fullstack_Backend.controller;

import com.WebServicesProject.Fullstack_Backend.model.User;
import com.WebServicesProject.Fullstack_Backend.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/AddUser")
    User addUser(@RequestBody User addUser) {
        return userRepository.save(addUser);
    }

    @GetMapping("/AllUsers")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
