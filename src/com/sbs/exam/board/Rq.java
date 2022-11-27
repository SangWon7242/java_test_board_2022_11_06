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

  public Map<String, String> getParams() {
    return params;
  }

  public String getUrlPath() {
    return urlPath;
  }
}
