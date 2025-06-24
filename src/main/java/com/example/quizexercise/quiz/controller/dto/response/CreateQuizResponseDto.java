package com.example.quizexercise.quiz.controller.dto.response;

import com.example.quizexercise.quiz.entity.Quiz;
import com.example.quizexercise.submission.entity.Submission;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateQuizResponseDto(String id, String content, List<QuestionResponseDto> questionList, List<Submission> submissionList) {}
