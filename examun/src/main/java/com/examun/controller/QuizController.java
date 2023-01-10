

package com.examun.controller;


import com.examun.models.Category;
import com.examun.models.Quiz;
import com.examun.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {


    private   QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //add Quiz
   @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        return  ResponseEntity.ok(this.quizService.addQuiz(quiz));
   }

   //update quiz
    @PutMapping("/")
    public  ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return  ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get All Quiz
    @GetMapping("/allQuizzes")
    public  ResponseEntity<?> getQuizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }


    //get quiz BY ID

    @GetMapping("/{qid}")
    public Quiz getQuiz(@PathVariable("qid") Long qid) {
     return  this.quizService.getQuiz(qid);
    }

   //delete Quiz
   @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable("qid") Long qid){
         this.quizService.deleteQuiz(qid);
   }

   // get quizzes of categories


    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid ) {
        Category category=new Category();
        category.setCid(cid);
        return  this.quizService.getQuizzesOfCategory(category);
    }

    //get quizzes active

    @GetMapping("/active")
    public  List<Quiz> getQuizzesActive(){
        return  this.quizService.getActiveQuizzes();
    }
    //get quiz Active of one Category

    @GetMapping("/category/active/{cid}")
    public  List<Quiz> getQuizCategoryActive( @PathVariable("cid") Long cid){
         Category category=new Category();
         category.setCid(cid);
        return  this.quizService.getActiveQuizzesOfCategory(category);
    }

}
