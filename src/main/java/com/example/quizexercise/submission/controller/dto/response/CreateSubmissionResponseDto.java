package com.example.quizexercise.submission.controller.dto.response;

import com.example.quizexercise.user.controller.dto.repsonse.GetUserResponseDto;
import java.util.List;

public record CreateSubmissionResponseDto(
        String id, String content, GetUserResponseDto user, List<GetAnswerResponseDto> answerList) {}
