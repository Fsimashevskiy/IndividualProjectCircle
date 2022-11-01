package com.app.crud.service;

import com.app.crud.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAllArticles();
    Article findArticleById(int id);
    Article findArticleByIdContains(int id);
    void save(Article article);
    void delete(int id);
}
