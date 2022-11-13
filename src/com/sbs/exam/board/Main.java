package com.sbs.exam.board;

import java.util.Scanner;

/*
### TODO 예시
- [] /usr/article/detail 입력처리
- [] /usr/article/detail 입력되면 가장 최근 게시물 정보 노출
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int articleLastId = 0;
    Article lastArticle = null;

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    while(true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();

      if(cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else if(cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 등록 ==");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();

        int id = articleLastId + 1;
        articleLastId = id;

        Article article = new Article(id, title, body);
        lastArticle = article;
        System.out.println("생성된 게시물 객체 : " + article);

        System.out.printf("%d번 게시물이 생성되었습니다.\n", id);
      }
      else if(cmd.equals("/usr/article/detail")) {
        if (lastArticle == null) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        Article article = lastArticle;

        System.out.println("== 게시물 상세내용 ==");
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.title);
        System.out.printf("내용 : %s\n", article.body);
      }
      else {
        System.out.printf("받은 명령어 : %s\n", cmd);
      }
    }

    sc.close();
  }
}

class Article {
  int id;
  String title;
  String body;

  public Article(int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }

  @Override
  public String toString() {
    String title = this.title != null ? "\"" + this.title + "\"" : null;
    String body = this.body != null ? "\"" + this.body + "\"" : null;

    return String.format("{id : %d, title : %s, body : %s}", id, title, body);
  }
}