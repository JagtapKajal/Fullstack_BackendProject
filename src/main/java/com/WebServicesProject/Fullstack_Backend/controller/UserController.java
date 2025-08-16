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


    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllUsers() {
        userRepository.deleteAll();
        return ResponseEntity.ok("All users have been deleted successfully.");
    }

    @GetMapping("/getUser/{id}")
    User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }
}
