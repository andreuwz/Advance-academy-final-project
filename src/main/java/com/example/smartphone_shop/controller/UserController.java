package com.example.smartphone_shop.controller;

import com.example.smartphone_shop.model.User;
import com.example.smartphone_shop.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class UserController {

    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/allusers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.returnAllUsers());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/userfirstname/{firstname}")
    public ResponseEntity<User> findUserByFirstname(@PathVariable String firstname) {
        return ResponseEntity.ok(userService.findUserByFirstname(firstname));
    }

    @GetMapping(value = "/userlastname/{lastname}")
    public ResponseEntity<User> findUserByLastname(@PathVariable String lastname) {
        return ResponseEntity.ok(userService.findUserByLastname(lastname));
    }

    @GetMapping(value = "/useremail/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmailAddress(email));
    }

    @DeleteMapping(value = "/userdelete/{firstname}")
    public ResponseEntity<HttpStatus> deleteByFirstname(@PathVariable String firstname) {
        userService.deleteUserByFirstname(firstname);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/usersdelete/deleteall")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.ok().build();
    }

}
