package com.app.crud.service;

import com.app.crud.model.Article;
import com.app.crud.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }


    @Override
    public Article findArticleById(int id) {
        return articleRepository.findArticleById(id);
    }

    @Override
    public Article findArticleByIdContains(int id) {
        return articleRepository.findArticleByIdContains(id);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void delete(int id) {
        articleRepository.delete(articleRepository.findArticleById(id));
    }
}
