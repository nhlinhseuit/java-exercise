package com.example.quizexercise.quiz.service;

import com.example.quizexercise.quiz.controller.dto.request.CreateQuizRequestDto;
import com.example.quizexercise.quiz.controller.dto.request.GetQuizListRequestDto;
import com.example.quizexercise.quiz.controller.dto.request.UpdateQuizRequestDto;
import com.example.quizexercise.quiz.controller.dto.response.CreateQuizResponseDto;
import com.example.quizexercise.quiz.controller.dto.response.GetQuizResponseDto;
import com.example.quizexercise.quiz.entity.Option;
import com.example.quizexercise.quiz.entity.Question;
import com.example.quizexercise.quiz.entity.Quiz;
import com.example.quizexercise.quiz.mapper.QuizMapper;
import com.example.quizexercise.quiz.repository.QuizRepository;
import jakarta.transaction.Transactional;
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
                questionRequestDto -> {
                  Question question =
                      Question.builder()
                          .content(questionRequestDto.getContent())
                          .quiz(quiz) // Gán quan hệ ngược - BAT BUOC
                          .build();

                  // Lặp từng option trong question
                  List<Option> optionList =
                      questionRequestDto.getOptionList().stream()
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

    quiz.setQuestionList(questionList);

    // Lưu quiz, đồng thời cascade lưu hết question và option:
    // Vi quiz co cascade toi question, question co cascade toi option
    Quiz savedQuiz = quizRepository.save(quiz);

    CreateQuizResponseDto quizDto = quizMapper.toCreateQuizDto(savedQuiz);

    return quizDto;
  }

  @Transactional
  public GetQuizResponseDto updateQuiz(
      String quizId, UpdateQuizRequestDto updateQuizListRequestDto) {

    Quiz quiz =
        quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));

    quiz.setContent(updateQuizListRequestDto.getContent());

    List<Question> newQuestionList =
        updateQuizListRequestDto.getQuestionList().stream()
            .map(
                (questionRequestDto) -> {
                  Question newQuestion =
                      Question.builder()
                          .content(questionRequestDto.getContent())
                          .quiz(quiz)
                          .build();

                  List<Option> newOptionList =
                      questionRequestDto.getOptionList().stream()
                          .map(
                              (optionRequestDto) -> {
                                Option newOption =
                                    Option.builder()
                                        .content(optionRequestDto.getContent())
                                        .question(newQuestion)
                                        .build();

                                return newOption;
                              })
                          .collect(Collectors.toList());

                  newQuestion.setOptionList(newOptionList);
                  return newQuestion;
                })
            .collect(Collectors.toList());

    // Khong sd duoc cach nay vi chi thay doi ref cua questList sang list moi, hibernate se k biet
    // can phai xoa gi
    //    quiz.setQuestionList(newQuestionList);

    quiz.getQuestionList().clear();
    quiz.getQuestionList().addAll(newQuestionList);
    quizRepository.save(quiz);

    return quizMapper.toDto(quiz);
  }
}
