package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private UserType userType;
//    private List<Long> favGenres;
//    private List<Long> favMovies;
//    private List<Long> comments;
}
