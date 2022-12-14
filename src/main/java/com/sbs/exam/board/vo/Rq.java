package com.sbs.exam.board.vo;

import com.sbs.exam.board.container.Container;
import com.sbs.exam.board.session.Session;
import com.sbs.exam.board.util.Util;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class Rq {
  private String url;
  private String urlPath;
  private Map<String, String> params;

  public int getIntParam(String paramName, int defaultValue) {

    if(params.containsKey(paramName) == false ) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(params.get(paramName));
    }
    catch ( NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getParam(String paramName, String defaultValue) {

    if(params.containsKey(paramName) == false ) {
      return defaultValue;
    }

    return params.get(paramName);
  }

  public Map<String, String> getParams() {
    return params;
  }

  public String getUrlPath() {
    return urlPath;
  }

  public Object getSessionAttr(String key) {
    Session session = Container.getSession();
    return session.getAttribute(key);
  }

  public void setSessionAttr(String key, Object value) {
    Session session = Container.getSession();
    session.setAttribute(key, value);
  }

  public void removeSessionAttr(String key) {
    Session session = Container.getSession();
    session.removeAttribute(key);
  }

  public boolean hasSessionAttr(String key) {
    Session session = Container.getSession();
    return session.hasAttribute(key);
  }

  public Member getLoginedMember() {
    return (Member)getSessionAttr("loginedMember");
  }

  public boolean isLogined() {
    return hasSessionAttr("loginedMember");
  }

  public void setCommand(String url) {
    urlPath = Util.getUrlPathFromUrl(url);
    params = Util.getParamsFromUrl(url);
  }

  public void login(Member member) {
    setSessionAttr("loginedMember", member);
  }

  public void logout() {
    removeSessionAttr("loginedMember");
  }
}
