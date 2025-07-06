package com.example.quizexercise.submission.controller.dto.request;

import com.example.quizexercise.quiz.entity.Quiz;
import com.example.quizexercise.submission.entity.Answer;
import com.example.quizexercise.user.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateSubmissionRequestDto {
    private String id;
    private String content;
    private User user;
    private Quiz quiz;
    private List<Answer> answerList;
}
