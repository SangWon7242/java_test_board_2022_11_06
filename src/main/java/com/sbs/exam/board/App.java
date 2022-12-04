package com.sbs.exam.board;

import com.sbs.exam.board.container.Container;
import com.sbs.exam.board.session.Session;
import com.sbs.exam.board.vo.Member;
import com.sbs.exam.board.vo.Rq;

import java.util.Map;
import java.util.Scanner;

public class App {


  void run() {
    Scanner sc = Container.getSc();
    Session session = Container.getSession();

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    while(true) {
      Member loginedMember = (Member)session.getAttribute("loginedMember");

      String promptName = "명령어";

      if(loginedMember != null ) {
        promptName = loginedMember.getLoginId();
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
        Container.getUsrArticleController().showList(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/write")) {
        Container.getUsrArticleController().actionWrite();
      }
      else if(rq.getUrlPath().equals("/usr/article/detail")) {
        Container.getUsrArticleController().actionDetail(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/modify")) {
        Container.getUsrArticleController().actionModify(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/delete")) {
        Container.getUsrArticleController().actionDelete(rq);
      }
      else if(rq.getUrlPath().equals("/usr/member/join")) {
        Container.getUsrMemberController().actionJoin();
      }
      else if(rq.getUrlPath().equals("/usr/member/login")) {
        Container.getUsrMemberController().actionLogin(rq);
      }
      else if(rq.getUrlPath().equals("/usr/member/logout")) {
        Container.getUsrMemberController().actionLogout(rq);
      }
      else {
        System.out.printf("받은 명령어 : %s\n", cmd);
      }
    }

    sc.close();
  }


}
