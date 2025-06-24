package com.example.quizexercise.submission.service;

import com.example.quizexercise.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService {
    private final QuizRepository quizRepository;
}
