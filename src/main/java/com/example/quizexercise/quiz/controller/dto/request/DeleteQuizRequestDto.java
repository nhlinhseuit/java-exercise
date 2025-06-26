package com.example.quizexercise.quiz.controller.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteQuizRequestDto {
    String quizId;
}
