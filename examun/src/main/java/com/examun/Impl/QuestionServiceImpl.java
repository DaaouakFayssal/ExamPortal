package com.examun.Impl;

import com.examun.models.Question;
import com.examun.models.Quiz;
import com.examun.repo.QuestionRepository;
import com.examun.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Transactional
public class QuestionServiceImpl  implements QuestionService {
     private  QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById( questionId).get();
    }

    @Override
    public List<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long questId) {
        Question question=new Question();
        question.setQuesId(questId);
        this.questionRepository.delete(question);
    }

    @Override
    public Question get(Long questionId) {
        return this.questionRepository.getReferenceById(questionId);
    }

}
