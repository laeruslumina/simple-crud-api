package com.dummy.app.rest.controller;

import com.dummy.app.rest.models.User;
import com.dummy.app.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public String saveUser (@RequestBody User user) {
        userRepository.save(user);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public String updateUser (@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepository.save(updatedUser);
        return "Updated...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser (@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "User with id: " + id + " has been deleted.";
    }
}
