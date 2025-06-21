package com.example.quizexercise.submission.entity;

import com.example.quizexercise.quiz.entity.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "answers")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  private String id;

  private String content;

  @OneToOne(fetch = FetchType.EAGER)
  private Question question;

  @ManyToOne()
  @JoinColumn(name = "submission_id")
  private Submission submission;
}
