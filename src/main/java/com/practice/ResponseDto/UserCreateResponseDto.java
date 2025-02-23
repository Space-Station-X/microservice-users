package com.practice.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponseDto {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String phone;
    private LocalDate registrationDate;
    private String isActive;
}
