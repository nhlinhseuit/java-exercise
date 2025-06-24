package com.example.quizexercise.quiz.controller.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record GetQuizResponseDto(
    String content, List<QuestionResponseDto> questionList) {
}
