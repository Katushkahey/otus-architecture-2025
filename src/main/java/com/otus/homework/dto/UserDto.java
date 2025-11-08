package com.otus.homework.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
}
