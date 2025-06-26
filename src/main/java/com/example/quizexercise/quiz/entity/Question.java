package com.example.quizexercise.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "questions")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  private String id;

  private String content;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
  private List<Option> optionList;

  @ManyToOne()
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;
}
