package com.practice.ResponseDto;

import java.util.List;

import com.practice.RequestDto.UserRequestDto;

public record UserPageResponseDto 
(
    List<UserRequestDto> userDto,
    int page,
    long totalElement
)
{}
