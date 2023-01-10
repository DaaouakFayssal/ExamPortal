package com.examun.controller;


import com.examun.models.Category;
import com.examun.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController( CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    //Add category
    @RequestMapping(value = "/", headers="Accept=application/json",
            method = RequestMethod.POST)
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }

    //update category
    @RequestMapping(value = "/", headers="Accept=application/json",
            method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(this.categoryService.updateCategory(category));
    }

    //Get Single Category
   @GetMapping("/{cid}")

    public Optional<Category> get(@PathVariable("cid") Long cid){
        return  this.categoryService.getCategory(cid);
   }
    //return all categories

    @GetMapping("/allCategory")

    public ResponseEntity<?>getAllCategories(){
        return ResponseEntity.ok( this.categoryService.getCategories());
    }

    //delete category whid id
    @DeleteMapping("/{cid}")
    public  void  deleteCategory(@PathVariable("cid") Long cid){
        this.categoryService.deleteCategory(cid);
    }

}
