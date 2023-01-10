package com.examun.repo;

import com.examun.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<Category , Long> {

}
