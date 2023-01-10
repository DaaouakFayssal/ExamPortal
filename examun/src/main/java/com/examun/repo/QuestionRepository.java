package com.examun.repo;

import com.examun.models.Question;
import com.examun.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question , Long> {

   List<Question>  findByQuiz(Quiz quiz);
}
