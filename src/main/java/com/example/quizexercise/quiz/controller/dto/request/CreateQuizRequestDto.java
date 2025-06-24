package com.example.quizexercise.quiz.controller.dto.request;

import com.example.quizexercise.quiz.entity.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateQuizRequestDto {
    private String content;
    private List<Question> questionList;
}
