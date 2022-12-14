package com.sbs.exam.board.repository;

import com.sbs.exam.board.vo.Article;
import com.sbs.exam.board.vo.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
  private List<Member> members;
  private int lastId;

  public MemberRepository() {
    lastId = 0;
    members = new ArrayList<>();
  }

  public int join(String title, String body) {
    int id = lastId + 1;
    Member member = new Member(id, title, body);
    members.add(member);
    lastId = id;

    return id;
  }

  public Member getMemberByLoginId(String loginId) {
    for(Member member : members) {
      if(member.getLoginId().equals(loginId)) {
        return member;
      }
    }
    return null;
  }
}
