package com.dummy.app.rest.controller;

import com.dummy.app.rest.models.User;
import com.dummy.app.rest.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/show")
    public List<User> showUsers(){return apiService.getUsers();}

    @PostMapping("/create")
    public String createUser(@RequestBody User user){return apiService.saveUser(user);}

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        return apiService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){return apiService.deleteUser(id);}
}
