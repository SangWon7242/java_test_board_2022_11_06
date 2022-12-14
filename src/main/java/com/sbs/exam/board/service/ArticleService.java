package com.sbs.exam.board.service;

import com.sbs.exam.board.repository.ArticleRepository;
import com.sbs.exam.board.vo.Article;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = new ArticleRepository();
  }

  public void makeTestData() {
    for (int i = 1; i <= 100; i++) {
      String title = "제목" + i;
      String body = "내용" + i;
      write(title, body);
    }
  }

  public int write(String title, String body) {
    return articleRepository.write(title, body);
  }

  public List<Article> getArticles() {
    return articleRepository.getArticles();
  }

  public Article getArticleById(int id) {
    return articleRepository.getArticleById(id);
  }

  public void deleteArticleById(int id) {
    articleRepository.deleteArticleById(id);
  }
}
