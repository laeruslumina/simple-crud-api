package com.dummy.app.rest.service;

import com.dummy.app.rest.models.User;
import com.dummy.app.rest.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ApiService {

    public List<User> getUsers();

    public String saveUser (User user);

    public String updateUser (long id, User user);

    public String deleteUser (long id);
}
