package com.bilgeadam.service;

import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService implements IServiceCrud<Movie> {
    private final IMovieRepository movieRepository;
    private final UserService userService;
    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return movieRepository.saveAll(t);
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findAllByRatingGreaterThan(double rate){
          return movieRepository.findAllByRatingGreaterThan(rate);
    }

    public List<Movie> findAllByUsersGenres(Long userid) {
        Optional<User> user=userService.findById(userid);
        if (user.isPresent()){
            List<Long> genres=user.get().getFavGenres();
            List<Movie> movies=movieRepository.findAll().stream().filter(x->x.getGenres().stream().anyMatch(genres::contains)).collect(Collectors.toList());
            System.out.println(movies.size());
          return movies;
        }else {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }

    }


  public List<Movie> findAllByPremiredBefore(String date){
        return movieRepository.findAllByPremiredBefore(LocalDate.parse(date));
  }

  public  Object [] searchbyRating(){
        return movieRepository.searchbyRating();
  }
  public  Object  searchbyRating(double rate){

        return movieRepository.searchbyRating(rate);
  }

  public List<Movie> findAllByRatingIn(){
      List<Double> ratings=List.of(7.0,8.0,9.0);
        return movieRepository.findAllByRatingIn(ratings);
  }
    public List<Movie> findAllByRatingIn(Double [] ratings){
        return movieRepository.findAllByRatingIn(Arrays.asList(ratings));
    }

    public List<Movie> findAllByNameIn(String [] movieNames ){

        return movieRepository.findAllByNameIn(movieNames);
    }
}
