package com.example.quizexercise.quiz.controller.dto.response;

import lombok.Builder;

@Builder
public record OptionResponseDto(String id, String content) {}
