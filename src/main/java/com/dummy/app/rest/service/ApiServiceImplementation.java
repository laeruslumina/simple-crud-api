package com.dummy.app.rest.service;

import com.dummy.app.rest.models.User;
import com.dummy.app.rest.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service

public class ApiServiceImplementation implements ApiService {

    private UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public String saveUser (@RequestBody User user) {
        userRepository.save(user);
        return "Saved...";
    }

    @Override
    public String updateUser (@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepository.save(updatedUser);
        return "Updated...";
    }

    @Override
    public String deleteUser (@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "User with id: " + id + " has been deleted.";
    }
}
