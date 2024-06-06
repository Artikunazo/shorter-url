package com.artikunazo.shorterurl.common;

import org.springframework.beans.factory.annotation.Value;

public class UrlConstants {
  private UrlConstants() {};

  public static final String URL_BASE = "http://localhost";
  public static final String PORT = "8080";
  public static final String CONTEXT_PATH = "/shorter-url/api/";
  public static final String NEW_DOMAIN = "https://new.domain/";

}
