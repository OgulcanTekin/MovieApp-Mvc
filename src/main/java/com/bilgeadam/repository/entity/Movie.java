package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String image;
    private String name;
    private String country;
    private Double rating;
    @Lob
    private String summary;
    private LocalDate premired;
    private String url;
    @ElementCollection
    private List<Long> genres;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> comments;
}
