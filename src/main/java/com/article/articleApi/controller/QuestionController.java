package com.article.articleApi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.article.articleApi.exception.ResourceNotFoundException;
import com.article.articleApi.model.Question;
import com.article.articleApi.repository.QuestionRepository;
import com.article.articleApi.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	//@Autowired
	//private QuestionService questionService;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@GetMapping
	public Page<Question> getQuestion(Pageable pageable){
		return questionRepository.findAll(pageable);
	}
	
	@PostMapping
	public Question createQuestions(@Valid @RequestBody Question question) {
		return questionRepository.save(question);
	}
	
	@PutMapping("/{id}")
	public Question updateQuestions(@PathVariable(value="id") Long id,@Valid @RequestBody Question questionRequest) {

		return questionRepository.findById(id).map(question->{
			question.setTitle(questionRequest.getTitle());
			question.setDescription(questionRequest.getDescription());
			
			return questionRepository.save(question);
		}).orElseThrow(()->new ResourceNotFoundException("Question not Found"));
	}

	
}
