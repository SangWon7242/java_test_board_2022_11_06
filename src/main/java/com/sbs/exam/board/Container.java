package com.sbs.exam.board;

import java.util.Scanner;

public class Container {
  static Scanner sc;
  static com.sbs.exam.board.Session session;
  static com.sbs.exam.board.UsrArticleController usrArticleController;
  static com.sbs.exam.board.UsrMemberController usrMemberController;

  static {
    sc = new Scanner(System.in);
    session = new com.sbs.exam.board.Session();
    usrArticleController = new com.sbs.exam.board.UsrArticleController();
    usrMemberController = new com.sbs.exam.board.UsrMemberController();
  }

  public static com.sbs.exam.board.Session getSession() {
    return session;
  }
}
