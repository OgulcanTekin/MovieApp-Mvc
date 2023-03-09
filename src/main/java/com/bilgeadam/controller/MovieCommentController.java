package com.bilgeadam.controller;

import com.bilgeadam.dto.request.MovieCommentCreateRequestDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.MovieCommentService;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/moviecomment")
public class MovieCommentController {

private final MovieCommentService movieCommentService;

private final UserService userService;
private  final MovieService movieService;

    @PostMapping("/save")
    public ModelAndView save(MovieCommentCreateRequestDto dto){


   MovieComment movieComment=movieCommentService.save(IUserMapper.INSTANCE.toMovieComment(dto));

        Movie movie=movieService.findById(dto.getMovieId()).get();
        movie.getComments().add(movieComment.getId());
        movieService.save(movie);
        User user=userService.findById(dto.getUserId()).get();
        user.getComments().add(movieComment.getId());
        userService.save(user);

    ModelAndView modelAndView=new ModelAndView();
    modelAndView.setViewName("redirect:/movie/findbyid/"+dto.getMovieId()+"?userId="+dto.getUserId());
    return  modelAndView;
    }

}
