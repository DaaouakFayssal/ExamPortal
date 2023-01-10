package com.examun.repo;

import com.examun.models.Category;
import com.examun.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz ,Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM quiz WHERE qid = ?1", nativeQuery = true)
    public void deleteQuiz(Quiz qid);

    public List<Quiz> findByCategory(Category category);
    public  List<Quiz> findByActive(Boolean b);
    public  List<Quiz> findByCategoryAndActive( Category c , Boolean b );
}

