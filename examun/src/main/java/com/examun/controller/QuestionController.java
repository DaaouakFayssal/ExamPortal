package com.examun.controller;

import com.examun.models.Question;
import com.examun.models.Quiz;
import com.examun.service.QuestionService;
import com.examun.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;
    private QuizService quizService;

    public QuestionController(QuestionService questionService, QuizService quizService) {
        this.questionService = questionService;
        this.quizService = quizService;
    }


    // add question
    @RequestMapping(value = "/" ,method = RequestMethod.POST,headers = "Content-Type= multipart/form-data ,application/json")
    public ResponseEntity<Question> addQuestion(@RequestBody  Question question ){
        return  ResponseEntity.ok(this.questionService.addQuestion(question));
    }


    //update question

    @PutMapping("/")
    public  ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get any question of quiz

    @GetMapping("/quiz/all/{qid}")
    public  ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
         Quiz quiz =new Quiz();
         quiz.setQid(qid);
         List<Question> questionOfQuiz =this.questionService.getQuestionOfQuiz(quiz);
      return ResponseEntity.ok(questionOfQuiz);

    }

    //Get Single Question

    @GetMapping("/{questId}")

    public  Question get(@PathVariable("questId") Long questId){
        return  this.questionService.getQuestion(questId);
    }

    //delete Question

    @DeleteMapping("/{questId}")
    public  void  deleteQuestion(@PathVariable("questId") Long questId){
        this.questionService.deleteQuestion(questId);
    }

    // evaluate quiz

    @PostMapping("/eval-quiz")
    public  ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions){
        System.out.println(questions);
               Double  marksGod  = Double.valueOf(0);
              Integer  correctAnswer=0;
              Integer   attemted=0;
              for(Question q:questions){

          Question question= this.questionService.get(q.getQuesId());

           if( question.getAnswer().equals( q.getGivenAwnser())){
              // correct
               correctAnswer++;
               Double markSingle =Double.parseDouble(questions.get(0).getQuiz().getMaxMark())/questions.size();
               marksGod+=markSingle;
           }
           if ( q.getGivenAwnser() !=null ){
            attemted++;
           }
        }
              Map<Object ,Object> map=Map.of("marksGod",marksGod,"correctAwnser",correctAnswer,"attemted",attemted);
        return ResponseEntity.ok(map);
    }
}
