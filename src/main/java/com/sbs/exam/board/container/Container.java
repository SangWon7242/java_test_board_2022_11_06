package com.sbs.exam.board.container;

import com.sbs.exam.board.controller.UsrArticleController;
import com.sbs.exam.board.controller.UsrMemberController;
import com.sbs.exam.board.repository.ArticleRepository;
import com.sbs.exam.board.service.ArticleService;
import com.sbs.exam.board.session.Session;
import lombok.Getter;

import java.util.Scanner;

public class Container {

  @Getter
  private static Scanner sc;
  @Getter
  private static Session session;
  @Getter
  private static UsrArticleController usrArticleController;
  @Getter
  private static UsrMemberController usrMemberController;

  @Getter
  private static ArticleService articleService;

  @Getter
  private static ArticleRepository articleRepository;

  static {
    sc = new Scanner(System.in);
    session = new Session();

    usrArticleController = new UsrArticleController();
    usrMemberController = new UsrMemberController();

    articleService = new ArticleService();
    articleRepository = new ArticleRepository();
  }

  public static Session getSession() {
    return session;
  }
}
