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

    @GetMapping("/userById/{id}")
    User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/EditUser/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable int id){
        return userRepository.findById(id).map(user->{
            user.setFname(newUser.getFname());
            user.setLname(newUser.getLname());
            user.setCity(newUser.getCity());
            user.setGrade(newUser.getGrade());
            user.setGender(newUser.getGender());
            user.setCourse(newUser.getCourse());
            return userRepository.save(user);
        }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/DeleteUser/{id}")
    String deleteUser(@PathVariable int id){
        if(userRepository.existsById(id)){

            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id +"Has Been Deleted Successfully";
    }

}
