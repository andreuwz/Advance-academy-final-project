package com.example.smartphone_shop.service;

import com.example.smartphone_shop.model.User;
import com.example.smartphone_shop.repository.UserRepository;
import com.example.smartphone_shop.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        userService = new UserService(userRepository);
    }

    @Test
    public void testOneNumberOfInvocations() {
       when(userRepository.findByFirstname("Abc"))
               .thenReturn(Optional.of(new User()));

       userService.findUserByFirstname("Abc");
       verify(userRepository, times(2)).findByFirstname("Abc");
    }

}
