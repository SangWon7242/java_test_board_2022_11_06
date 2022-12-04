package com.sbs.exam.board;

import java.util.Map;

class Rq {
  private String url;
  private String urlPath;
  private Map<String, String> params;

  Rq(String url) {
    this.url = url;
    urlPath = Util.getUrlPathFromUrl(this.url);
    params = Util.getParamsFromUrl(this.url);
  }

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

  public void setSessionAttr(String key, Object value) {
    Session session = Container.getSession();

    session.setAttribute(key, value);
  }

  public void removeSessionAttr(String key) {
    Session session = Container.getSession();

    session.removeAttribute(key);
  }
}
