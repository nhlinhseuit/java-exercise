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
          summary = "Get quiz by id",
          description = "Return the quiz and question list based on quiz id, each question has option list."
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Success"),
          @ApiResponse(responseCode = "404", description = "TEMP: Quiz id not found"),
          @ApiResponse(responseCode = "500", description = "TEMP: Internal error")
  })
  public GetQuizResponseDto getQuiz(@PathVariable("quizId") String quizId) {
    return quizService.getQuiz(quizId);
  }
}
