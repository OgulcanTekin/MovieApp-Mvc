package com.ogulcan.repository;

import com.ogulcan.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Transactional
@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAllByRatingGreaterThan(double rate);

    List<Movie> findAllByPremiredBefore(LocalDate date);
    List<Movie> findAllByPremiredBetween(LocalDate date,LocalDate nextDate);

    @Query("select rating,count(rating) from  Movie group by rating")
    Object [] searchbyRating();
    @Query("select rating,count(rating) from  Movie group by rating having rating=?1")
    Object  searchbyRating(double rate);

    List<Movie> findAllByRatingIn(List<Double> ratings);

    List<Movie> findAllByNameIn(String [] movieNames);

    int countAllByRating(double rating);

}
