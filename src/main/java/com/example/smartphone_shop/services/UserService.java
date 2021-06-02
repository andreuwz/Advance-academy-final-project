package com.example.smartphone_shop.services;

import com.example.smartphone_shop.exception.UserNotFoundException;
import com.example.smartphone_shop.model.User;
import com.example.smartphone_shop.repository.UserRepository;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser (@NonNull User user) {
        user.setUserCreationDate(LocalDateTime.now());
        userRepository.save(user);
        System.out.println("User saved successfully!");
    }

    public void deleteUserByFirstname(@NonNull String firstname) {
        userRepository.deleteByFirstName(firstname);
        System.out.println("User deleted successfully");
    }

    public User findUserByFirstname(@NonNull String firstname) {
         User foundUserF = userRepository.findByFirstname(firstname)
                 .orElseThrow(() -> new UserNotFoundException(String.format("User not found with firstname: %s",
                         firstname)));
         return foundUserF;
    }

    public User findUserByLastname(@NonNull String lastname) {
        User foundUserL = userRepository.findByLastname(lastname)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with lastname: %s",
                        lastname)));
                return foundUserL;
    }

    public User findByEmailAddress(@NonNull String address) {
        User foundUserE = userRepository.findByEmailAddress(address)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with email: %s",
                        address)));
        return foundUserE;
    }

    public List<User> returnAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
        System.out.println("All users deleted successfully!");
    }

}
