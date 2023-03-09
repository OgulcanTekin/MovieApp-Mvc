package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.MovieCommentCreateRequestDto;
import com.bilgeadam.dto.request.UserResgisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);

    User toUser(final UserResgisterRequestDto dto);

    LoginResponseDto toLoginResponseDto(final User user);

    MovieComment toMovieComment(final MovieCommentCreateRequestDto dto);
}
