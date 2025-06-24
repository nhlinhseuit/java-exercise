package com.example.quizexercise.submission.entity;

import com.example.quizexercise.quiz.entity.Quiz;
import com.example.quizexercise.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "submissions")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  private String id;

  private String content;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "submission")
  private List<Answer> answerList;
}
