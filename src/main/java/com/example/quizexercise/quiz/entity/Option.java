package com.example.quizexercise.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "options")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Option {
  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  private String id;

  private String content;

  @ManyToOne()
  @JoinColumn(name = "question_id")
  private Question question;
}
