package com.example.quizexercise.quiz.controller;

import com.example.quizexercise.quiz.controller.dto.request.CreateQuizRequestDto;
import com.example.quizexercise.quiz.controller.dto.request.GetQuizListRequestDto;
import com.example.quizexercise.quiz.controller.dto.response.CreateQuizResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.GetQuizResponseDto;
import com.example.quizexercise.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
@RequiredArgsConstructor
public class QuizController {
  private final QuizService quizService;

  @GetMapping
  @ApiResponses(value = {})
  public List<GetQuizResponseDto> getQuizList(
      @RequestBody GetQuizListRequestDto getQuizListRequestDto) {
    return quizService.getQuizList(getQuizListRequestDto);
  }

  @PostMapping
  public CreateQuizResponseDto createQuiz(
      @RequestBody CreateQuizRequestDto createQuizListRequestDto) {
    return quizService.createQuiz(createQuizListRequestDto);
  }

  @GetMapping("/{quizId}")
  @Operation(
          summary = "Lấy thông tin bài quiz theo ID",
          description = "Trả về nội dung bài quiz và danh sách câu hỏi kèm theo các phương án lựa chọn dựa trên ID của quiz."
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Lấy quiz thành công"),
          @ApiResponse(responseCode = "404", description = "TEMP: Không tìm thấy quiz với ID được cung cấp"),
          @ApiResponse(responseCode = "500", description = "TEMP: Lỗi hệ thống")
  })
  public GetQuizResponseDto getQuiz(@PathVariable("quizId") String quizId) {
    return quizService.getQuiz(quizId);
  }
}
