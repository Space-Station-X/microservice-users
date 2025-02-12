package com.practice.RequestDto;

import java.time.LocalDate;

public record UserCreateRequestDto
(
    String username,
    String password,
    String email,
    String fullname,
    String phone,
    LocalDate registrationDate,
    String isActive
)
{}
