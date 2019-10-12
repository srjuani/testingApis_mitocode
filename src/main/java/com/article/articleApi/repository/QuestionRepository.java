package com.article.articleApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.article.articleApi.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
