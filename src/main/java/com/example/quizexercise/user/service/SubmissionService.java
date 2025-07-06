package com.example.quizexercise.user.service;

import com.example.quizexercise.quiz.repository.QuizRepository;
import com.example.quizexercise.submission.controller.dto.request.CreateSubmissionRequestDto;
import com.example.quizexercise.submission.controller.dto.response.CreateSubmissionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService {
    private final QuizRepository quizRepository;

    public CreateSubmissionResponseDto createSubmission(CreateSubmissionRequestDto createSubmissionRequestDto) {

    }
}
