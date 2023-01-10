
package com.examun.service;

import com.examun.models.Category;
import com.examun.models.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz (Quiz quiz);
    public Set<Quiz> getQuizzes();
    Quiz getQuiz(Long quizId);
    public  void  deleteQuiz(Long quizId);

     List<Quiz> getQuizzesOfCategory(Category category);

      List <Quiz> getActiveQuizzes();
     List<Quiz> getActiveQuizzesOfCategory(Category c);

}
