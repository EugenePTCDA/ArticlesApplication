package com.example.service;

import com.example.model.Article;
import com.example.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article article) {
        Article existingArticle = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        existingArticle.setTitle(article.getTitle());
        existingArticle.setContent(article.getContent());
        return articleRepository.save(existingArticle);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
