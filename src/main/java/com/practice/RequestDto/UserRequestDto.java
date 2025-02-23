package com.practice.RequestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "")

public class UserRequestDto
{
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String phone;
    private LocalDate registrationDate;
    private String isActive;
}
