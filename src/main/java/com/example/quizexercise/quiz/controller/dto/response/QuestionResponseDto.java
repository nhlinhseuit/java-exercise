package com.example.quizexercise.quiz.controller.dto.response;

import java.util.List;
import lombok.Builder;

@Builder
public record QuestionResponseDto(
String content, List<OptionResponseDto> optionList) {}
