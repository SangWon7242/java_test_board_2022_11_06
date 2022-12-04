package com.sbs.exam.board;

import java.util.Map;
import java.util.Scanner;

public class App {


  void run() {
    Scanner sc = com.sbs.exam.board.Container.sc;
    com.sbs.exam.board.Session session = com.sbs.exam.board.Container.getSession();

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    while(true) {
      Member loginedMember = (Member)session.getAttribute("loginedMember");

      String promptName = "명령어";

      if(loginedMember != null ) {
        promptName = loginedMember.loginId;
      }

      System.out.printf("%s) ", promptName);
      String cmd = sc.nextLine();

      com.sbs.exam.board.Rq rq = new com.sbs.exam.board.Rq(cmd);
      Map<String, String> params = rq.getParams();

      if(rq.getUrlPath().equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else if(rq.getUrlPath().equals("/usr/article/list")) {
        com.sbs.exam.board.Container.usrArticleController.showList(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/write")) {
        com.sbs.exam.board.Container.usrArticleController.actionWrite();
      }
      else if(rq.getUrlPath().equals("/usr/article/detail")) {
        com.sbs.exam.board.Container.usrArticleController.actionDetail(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/modify")) {
        com.sbs.exam.board.Container.usrArticleController.actionModify(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/delete")) {
        com.sbs.exam.board.Container.usrArticleController.actionDelete(rq);
      }
      else if(rq.getUrlPath().equals("/usr/member/join")) {
        com.sbs.exam.board.Container.usrMemberController.actionJoin();
      }
      else if(rq.getUrlPath().equals("/usr/member/login")) {
        com.sbs.exam.board.Container.usrMemberController.actionLogin(rq);
      }
      else if(rq.getUrlPath().equals("/usr/member/logout")) {
        com.sbs.exam.board.Container.usrMemberController.actionLogout(rq);
      }
      else {
        System.out.printf("받은 명령어 : %s\n", cmd);
      }
    }

    sc.close();
  }


}
