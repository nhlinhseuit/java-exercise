package com.example.quizexercise.quiz.entity;

import com.example.quizexercise.submission.entity.Submission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "quizs")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  private String id;

  private String content;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "question_id")
  private List<Question> questions;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "submission_id")
  private List<Submission> submissions;
}
