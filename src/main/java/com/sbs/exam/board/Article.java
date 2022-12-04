package com.sbs.exam.board;

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