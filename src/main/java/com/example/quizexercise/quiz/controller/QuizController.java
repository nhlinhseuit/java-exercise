package com.example.quizexercise.quiz.controller;

import com.example.quizexercise.quiz.controller.dto.request.CreateQuizRequestDto;
import com.example.quizexercise.quiz.controller.dto.request.GetQuizListRequestDto;
import com.example.quizexercise.quiz.controller.dto.request.UpdateQuizRequestDto;
import com.example.quizexercise.quiz.controller.dto.response.CreateQuizResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.GetQuizResponseDto;
import com.example.quizexercise.quiz.service.QuizService;
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

  @PutMapping("/{quizId}")
  public GetQuizResponseDto updateQuiz(@PathVariable("quizId") String quizId ,@RequestBody UpdateQuizRequestDto updateQuizListRequestDto) {
    return quizService.updateQuiz(quizId, updateQuizListRequestDto);
  }
}
