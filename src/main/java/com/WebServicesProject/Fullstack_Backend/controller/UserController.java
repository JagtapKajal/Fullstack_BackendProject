package com.WebServicesProject.Fullstack_Backend.controller;

import com.WebServicesProject.Fullstack_Backend.exception.UserNotFoundException;
import com.WebServicesProject.Fullstack_Backend.model.User;
import com.WebServicesProject.Fullstack_Backend.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping
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
