package com.example.quizexercise.quiz.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
@Schema(description = "DTO phản hồi khi lấy một quiz")
public record GetQuizResponseDto(
    @Schema(description = "Nội dung của quiz", example = "Quiz về Java cơ bản") String content,
    @Schema(description = "Danh sách câu hỏi thuộc quiz") List<QuestionResponseDto> questionList) {}
