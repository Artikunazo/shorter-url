package com.artikunazo.shorterurl.domain;

import java.security.SecureRandom;
import java.util.Random;

public class ShortUrlConfig {

  private static final String ALPHANUMERIC_ALPHABET = 
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private static final int DEFAULT_KEY_LENGTH = 7;
  private final Random random = new SecureRandom();

  public String shortUrlGenerator() {
    return shortUrlGenerator(DEFAULT_KEY_LENGTH);
  }

  public String shortUrlGenerator(int length) {
    StringBuilder builder = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int index = random.nextInt(ALPHANUMERIC_ALPHABET.length());
      builder.append(ALPHANUMERIC_ALPHABET.charAt(index));
    }
    return builder.toString();
  }
}
