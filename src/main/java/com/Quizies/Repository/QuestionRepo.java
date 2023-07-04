package com.Quizies.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Quizies.Entity.Question;


public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);

}
