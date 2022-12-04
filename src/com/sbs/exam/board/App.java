package com.sbs.exam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {


  void run() {
    Scanner sc = Container.sc;
    Session session = Container.getSession();

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

      Rq rq = new Rq(cmd);
      Map<String, String> params = rq.getParams();

      if(rq.getUrlPath().equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else if(rq.getUrlPath().equals("/usr/article/list")) {
        Container.usrArticleController.showList(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/write")) {
        Container.usrArticleController.actionWrite();
      }
      else if(rq.getUrlPath().equals("/usr/article/detail")) {
        Container.usrArticleController.actionDetail(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/modify")) {
        Container.usrArticleController.actionModify(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/delete")) {
        Container.usrArticleController.actionDelete(rq);
      }
      else if(rq.getUrlPath().equals("/usr/member/join")) {
        Container.usrMemberController.actionJoin();
      }
      else if(rq.getUrlPath().equals("/usr/member/login")) {
        Container.usrMemberController.actionLogin(rq);
      }
      else {
        System.out.printf("받은 명령어 : %s\n", cmd);
      }
    }

    sc.close();
  }


}
