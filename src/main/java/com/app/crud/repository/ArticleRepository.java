package com.app.crud.repository;

import com.app.crud.model.Article;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findAllByUser(User user);
    List<Article> findAllByUserContains(User user);
    Article findArticleById(int id);
    Article findArticleByIdContains(int id);
}
