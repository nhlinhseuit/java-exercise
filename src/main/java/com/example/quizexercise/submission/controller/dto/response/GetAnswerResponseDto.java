package com.example.quizexercise.submission.controller.dto.response;

import com.example.quizexercise.submission.entity.Answer;
import com.example.quizexercise.user.controller.dto.repsonse.GetUserResponseDto;
import java.util.List;

public record GetAnswerResponseDto(String id, String content) {}
