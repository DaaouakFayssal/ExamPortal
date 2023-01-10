package com.examun.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long cid;
    private String title;
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Quiz> quizzes =new HashSet<Quiz>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return cid != null && Objects.equals(cid, category.cid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
