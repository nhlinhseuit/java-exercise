package com.example.quizexercise.quiz.mapper;

import com.example.quizexercise.quiz.controller.dto.response.CreateQuizResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.GetQuizResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.OptionResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.QuestionResponseDto;
import com.example.quizexercise.quiz.entity.Option;
import com.example.quizexercise.quiz.entity.Question;
import com.example.quizexercise.quiz.entity.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuizMapper {

  // ! Mapping for Get ALL API

  // MapStruct sẽ xử lý Quiz → GetQuizResponseDto
  @Mapping(
      target = "questionList",
      source = "questionList") // can gan List<Quesion> toi List<QuestionResponseDto>
  GetQuizResponseDto toDto(Quiz quiz);

  // Các hàm thủ công dùng default
  default QuestionResponseDto toDto(Question question) {
    return new QuestionResponseDto(
        question.getId(),
        question.getContent(),
        question.getOptionList().stream().map(this::toDto).toList());
  }

  default OptionResponseDto toDto(Option option) {
    return new OptionResponseDto(option.getId(), option.getContent());
  }

  // ! Mapping for Crate quiz API
  CreateQuizResponseDto toCreateQuizDto(Quiz quiz);
}
