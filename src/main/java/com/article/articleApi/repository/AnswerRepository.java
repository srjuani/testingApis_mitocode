package com.article.articleApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.article.articleApi.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {

	List<Answer> findByQuestionId(long questionId);
}
