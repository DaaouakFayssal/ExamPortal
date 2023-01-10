
package com.examun.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long quesId;

    @Column(length = 5000)
    private String content ;
    @Transient
    private  String givenAwnser;
    private  String image;
    private  String option1;
    private  String option2;
    private  String option3;
    private  String option4;
    private  String answer;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Quiz quiz;

}
