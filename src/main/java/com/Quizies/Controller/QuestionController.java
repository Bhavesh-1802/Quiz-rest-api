package com.Quizies.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quizies.Entity.Question;
import com.Quizies.Repository.QuestionRepo;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionRepo repo;
	
	@GetMapping("/allquestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return new ResponseEntity<List<Question>>(repo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Question>> getQuestionbyid(@PathVariable int id)
	{
		return new ResponseEntity<Optional<Question>>(repo.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/{category}")
	public ResponseEntity<List<Question>> getQuestionbycategory(@PathVariable String category)
	{
		return new ResponseEntity<List<Question>>(repo.findByCategory(category), HttpStatus.OK);
	}

}
