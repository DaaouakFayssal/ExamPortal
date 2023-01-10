
package com.examun.service;

import com.examun.models.Question;
import com.examun.models.Quiz;

import java.util.List;
import java.util.Set;


public interface QuestionService {


    public Question addQuestion(Question question);

    public  Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public List<Question> getQuestionOfQuiz(Quiz quiz);

    public  void  deleteQuestion(Long questId);

    public  Question get(Long questionId);
}
