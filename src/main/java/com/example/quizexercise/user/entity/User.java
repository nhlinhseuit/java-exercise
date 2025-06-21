package com.example.quizexercise.user.entity;

import com.example.quizexercise.submission.entity.Submission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "users")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @GeneratedValue(strategy = GenerationType.UUID)
  @Id
  private String id;

  private String username;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
  private List<Submission> submissions;
}
