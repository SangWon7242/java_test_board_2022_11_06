package com.sbs.exam.board.service;

import com.sbs.exam.board.repository.MemberRepository;
import com.sbs.exam.board.vo.Member;

public class MemberService {
  private MemberRepository memberRepository;

  public MemberService() {
    memberRepository = new MemberRepository();
  }

  public void makeTestData() {
    for (int i = 1; i <= 3; i++) {
      String loginId = "user" + i;
      String loginPw = "user" + i;

      join(loginId, loginPw);
    }
  }

  public int join(String loginId, String loginPw) {
    return memberRepository.join(loginId, loginPw);
  }

  public Member getMemberByLoginId(String loginId) {
    return memberRepository.getMemberByLoginId(loginId);
  }
}
