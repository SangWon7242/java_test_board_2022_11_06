package com.sbs.exam.board;

class Member {
  int id;
  String loginId;
  String loginPw;

  public Member(int id, String loginId, String loginPw) {
    this.id = id;
    this.loginId = loginId;
    this.loginPw = loginPw;
  }

  @Override
  public String toString() {
    String loginId = this.loginId != null ? "\"" + this.loginId + "\"" : null;
    String loginPw = this.loginPw != null ? "\"" + this.loginPw + "\"" : null;

    return String.format("{id : %d, title : %s, body : %s}", id, loginId, loginPw);
  }
}