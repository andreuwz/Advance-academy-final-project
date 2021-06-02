package com.example.smartphone_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    // data transfer object - without the Id and password attributes from the "parent" class User

    private Long id;

    private String firstname;

    private LocalDateTime userDtoDateOfCreation;

    private String emailAddress;

}
