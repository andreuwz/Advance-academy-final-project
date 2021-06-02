package com.example.smartphone_shop.services;

import com.example.smartphone_shop.dto.UserDto;
import com.example.smartphone_shop.exception.RecordNotFoundException;
import com.example.smartphone_shop.model.User;
import com.example.smartphone_shop.repository.UserRepository;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        userRepository.deleteByFirstname(firstname);
        System.out.println("User deleted successfully");
    }

    public UserDto findUserByFirstname(@NonNull String firstname) {
         User foundUserF = userRepository.findByFirstname(firstname)
                 .orElseThrow(() -> new RecordNotFoundException(String.format("User not found with firstname: %s",
                         firstname)));
        UserDto userDtoF = new UserDto();
        userDtoF.setFirstname(foundUserF.getFirstname());
        userDtoF.setUserDtoDateOfCreation(foundUserF.getUserCreationDate());
        userDtoF.setEmailAddress(foundUserF.getEmailAddress());
         return userDtoF;
    }

    public UserDto findUserByLastname(@NonNull String lastname) {
        User foundUserL = userRepository.findByLastname(lastname)
                .orElseThrow(() -> new RecordNotFoundException(String.format("User not found with lastname: %s",
                        lastname)));
        UserDto userDtoL = new UserDto();
        userDtoL.setFirstname(foundUserL.getFirstname());
        userDtoL.setUserDtoDateOfCreation(foundUserL.getUserCreationDate());
        userDtoL.setEmailAddress(foundUserL.getEmailAddress());
        return userDtoL;

    }

    public UserDto findByEmailAddress(@NonNull String address) {
        User foundUserE = userRepository.findByEmailAddress(address)
                .orElseThrow(() -> new RecordNotFoundException(String.format("User not found with email: %s",
                        address)));
        UserDto userDtoE = new UserDto();
        userDtoE.setFirstname(foundUserE.getFirstname());
        userDtoE.setUserDtoDateOfCreation(foundUserE.getUserCreationDate());
        userDtoE.setEmailAddress(foundUserE.getEmailAddress());
        return userDtoE;
    }

    public List<UserDto> returnAllUsers(){
        List<User> allUsers = userRepository.findAll();
        List<UserDto> DtoUsers = new ArrayList<>();
        for (User oldUsers : allUsers) {
            UserDto userDto = new UserDto();
            userDto.setUserDtoDateOfCreation(oldUsers.getUserCreationDate());
            userDto.setId(oldUsers.getId());
            userDto.setFirstname(oldUsers.getFirstname());
            userDto.setEmailAddress(oldUsers.getEmailAddress());
        }
        return DtoUsers;
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
        System.out.println("All users deleted successfully!");
    }

}
