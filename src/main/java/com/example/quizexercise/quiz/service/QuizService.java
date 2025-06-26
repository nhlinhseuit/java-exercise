package com.example.quizexercise.quiz.service;

import com.example.quizexercise.quiz.controller.dto.request.CreateQuizRequestDto;
import com.example.quizexercise.quiz.controller.dto.request.DeleteQuizRequestDto;
import com.example.quizexercise.quiz.controller.dto.request.GetQuizListRequestDto;
import com.example.quizexercise.quiz.controller.dto.response.CreateQuizResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.DeleteQuizResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.GetQuizResponseDto;
import com.example.quizexercise.quiz.entity.Option;
import com.example.quizexercise.quiz.entity.Question;
import com.example.quizexercise.quiz.entity.Quiz;
import com.example.quizexercise.quiz.mapper.QuizMapper;
import com.example.quizexercise.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {
  private final QuizRepository quizRepository;
  private final QuizMapper quizMapper;

  public List<GetQuizResponseDto> getQuizList(GetQuizListRequestDto requestDto) {
    List<GetQuizResponseDto> quizListDto =
        quizRepository.findAll().stream().map(quizMapper::toDto).toList();

    return quizListDto;
  }

  public CreateQuizResponseDto createQuiz(CreateQuizRequestDto createQuizListRequestDto) {
    Quiz quiz = Quiz.builder().content(createQuizListRequestDto.getContent()).build();

    // Lặp từng câu hỏi từ request
    List<Question> questionList =
        createQuizListRequestDto.getQuestionList().stream()
            .map(
                questionDto -> {
                  Question question =
                      Question.builder()
                          .content(questionDto.getContent())
                          .quiz(quiz) // Gán quan hệ ngược - BAT BUOC
                          .build();

                  // Lặp từng option trong question
                  List<Option> optionList =
                      questionDto.getOptionList().stream()
                          .map(
                              optionDto ->
                                  Option.builder()
                                      .content(optionDto.getContent())
                                      .question(question) // Gán quan hệ ngược - BAT BUOC
                                      .build())
                          .collect(Collectors.toList());

                  question.setOptionList(optionList);
                  return question;
                })
            .collect(Collectors.toList());

    quiz.setQuestionList(createQuizListRequestDto.getQuestionList());

    // Lưu quiz, đồng thời cascade lưu hết question và option:
      // Vi quiz co cascade toi question, question co cascade toi option
    Quiz savedQuiz = quizRepository.save(quiz);

    CreateQuizResponseDto quizDto = quizMapper.toCreateQuizDto(savedQuiz);

    return quizDto;
  }

    public DeleteQuizResponseDto deleteQuiz(DeleteQuizRequestDto deleteQuizListRequestDto) {
      quizRepository.deleteById(deleteQuizListRequestDto.getQuizId());

      return DeleteQuizResponseDto.builder()
              .message("Deleted quiz id " + deleteQuizListRequestDto.getQuizId())
              .build();
    }
}
