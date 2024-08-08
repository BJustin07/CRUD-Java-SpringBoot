package com.example.crudapi.Controller;

import com.example.crudapi.Model.UserEntity;
import com.example.crudapi.Model.UserException;
import com.example.crudapi.Model.UserModel;
import com.example.crudapi.Repositories.UserRepository;
import com.example.crudapi.Service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUserById(id);
    }
    @PutMapping("/users/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel userModel) throws Exception {
        return userService.updateUserById(id, userModel);
    }
    @PostMapping("/users")
    public void createUser(@RequestBody UserModel userModel) {
        userService.createUser(userModel);
    }
    @GetMapping("/users")
    public List<UserModel> getAllUsers() throws Exception {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserModel getUser(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }
}
