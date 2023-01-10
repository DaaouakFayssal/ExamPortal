package com.examun.Impl;

import com.examun.models.Category;
import com.examun.models.Quiz;
import com.examun.repo.QuizRepository;
import com.examun.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
  private  QuizRepository quizRepository;

    public QuizServiceImpl( QuizRepository quizRepository) {
        this.quizRepository = quizRepository;


    }

    @Override
    public Quiz addQuiz(Quiz quiz) {

        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {

        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new  HashSet<>(
                this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }


    @Override
    public void deleteQuiz(Long quizId) {
     Quiz quiz =new Quiz();
     quiz.setQid(quizId);
     this.quizRepository.deleteQuiz(quiz);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepository.findByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c,true);
    }


}
