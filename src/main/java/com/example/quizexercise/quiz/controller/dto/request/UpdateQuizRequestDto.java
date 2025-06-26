package com.example.quizexercise.quiz.controller.dto.request;

import com.example.quizexercise.quiz.entity.Question;
import com.example.quizexercise.submission.entity.Submission;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateQuizRequestDto {
    private String content;
    private List<Question> questionList;
    private List<Submission> submissionList;
}
