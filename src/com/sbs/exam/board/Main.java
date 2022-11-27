package com.sbs.exam.board;

import java.util.*;

public class Main {
  static int articleLastId = 0;
  static List<Article> articles = new ArrayList<>();

  static void makeTestData() {
    for(int i = 1; i <= 100; i++ ) {
      articles.add(new Article(i, "제목" + i, "내용" + i));
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    makeTestData();

    if(articles.size() > 0) {
      articleLastId = articles.get(articles.size() - 1).id;
    }

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    while(true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();

      Rq rq = new Rq(cmd);
      Map<String, String> params = rq.getParams();

      if(rq.getUrlPath().equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else if(rq.getUrlPath().equals("/usr/article/list")) {
       actionUsrArticleList(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/write")) {
        actionUsrArticleWrite(sc);
      }
      else if(rq.getUrlPath().equals("/usr/article/detail")) {
        actionUsrArticleDetail(rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/modify")) {
        actionUsrArticleModify(sc, rq);
      }
      else if(rq.getUrlPath().equals("/usr/article/delete")) {
        actionUsrArticleDelete(rq);
      }
      else {
        System.out.printf("받은 명령어 : %s\n", cmd);
      }
    }

    sc.close();
  }

  private static void actionUsrArticleDelete(Rq rq) {
    Map<String, String> params = rq.getParams();

    if(params.containsKey("id") == false) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    }
    catch (NumberFormatException e) {
      System.out.println("id를 정수형태로 입력해주세요.");
      return;
    }

    Article foundArticle = null;

    for(Article article : articles) {
      if(article.id == id) {
        foundArticle = article;
        break;
      }
      else if (article.id != id) {
        System.out.println("해당 게시물은 존재하지 않습니다.");
        return;
      }
    }

    articles.remove(foundArticle);

    System.out.printf("%d번 게시물을 삭제하였습니다.\n", id);
  }

  private static void actionUsrArticleModify(Scanner sc, Rq rq) {
    Map<String, String> params = rq.getParams();

    if(params.containsKey("id") == false) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    }
    catch (NumberFormatException e) {
      System.out.println("id를 정수형태로 입력해주세요.");
      return;
    }

    Article article = articles.get(id - 1);

    if (id > articles.size()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    System.out.printf("새 제목 : ");
    article.title = sc.nextLine();
    System.out.printf("새 내용 : ");
    article.body = sc.nextLine();

    System.out.printf("%d번 게시물을 수정하였습니다.\n", article.id);
  }

  private static void actionUsrArticleWrite(Scanner sc) {
    System.out.println("== 게시물 등록 ==");
    System.out.printf("제목 : ");
    String title = sc.nextLine();
    System.out.printf("내용 : ");
    String body = sc.nextLine();

    int id = articleLastId + 1;
    articleLastId = id;

    Article article = new Article(id, title, body);

    articles.add(article);
    System.out.println("생성된 게시물 객체 : " + article);

    System.out.printf("%d번 게시물이 생성되었습니다.\n", id);
  }

  private static void actionUsrArticleDetail(Rq rq) {
    Map<String, String> params = rq.getParams();

    if(params.containsKey("id") == false) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    }
    catch (NumberFormatException e) {
      System.out.println("id를 정수형태로 입력해주세요.");
      return;
    }

    Article article = articles.get(id - 1);

    if (id > articles.size()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    System.out.println("== 게시물 상세내용 ==");
    System.out.printf("번호 : %d\n", article.id);
    System.out.printf("제목 : %s\n", article.title);
    System.out.printf("내용 : %s\n", article.body);
  }

  private static void actionUsrArticleList(Rq rq) {
    Map<String, String> params = rq.getParams();

    System.out.println("== 게시물 리스트 ==");
    System.out.println("-------------------");
    System.out.println("번호 / 제목");

    // 검색시작
    List<Article> filteredArticles = articles;

    if( params.containsKey("searchKeyword")) {
      String searchKeyword = params.get("searchKeyword");

      filteredArticles = new ArrayList<>();

      for(Article article : articles) {
        boolean matched = article.title.contains(searchKeyword) || article.body.contains(searchKeyword);
        if(matched) {
          filteredArticles.add(article);
        }
      }
      // 검색 끝
    }

    List<Article> sortedArticles = filteredArticles;

    boolean orderByIdDesc = true;
    if(params.containsKey("orderBy") && params.get("orderBy").equals("idAsc")) {
      orderByIdDesc = false;
    }

    if( orderByIdDesc ) {
      sortedArticles = Util.reverseList(sortedArticles);
    }

    for( Article article : sortedArticles ) {
      System.out.printf("%d / %s\n", article.id, article.title);
    }


    System.out.println("-------------------");
  }


}





