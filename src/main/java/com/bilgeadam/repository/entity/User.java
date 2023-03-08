package com.bilgeadam.repository.entity;


import com.bilgeadam.repository.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
/*
    userrepositroy -userservice -usercontroller
    -register islemi yapalım ve verileri teker teker alalım
    -bu veriler name surname password ve email daha sonra databsede kullanıcı kaydı olusturacagız.

 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surName;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(length = 32)
    private String password;
    @ElementCollection
    private List<Long> favGenres;
    @ElementCollection
    private List<Long> favMovies;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserType userType=UserType.USER;
    @ElementCollection
    private List<Long> comments;

}
