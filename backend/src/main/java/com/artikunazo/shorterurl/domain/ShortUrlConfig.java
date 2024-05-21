package com.artikunazo.shorterurl.domain;

import java.util.List;
import java.util.Random;

public class ShortUrlConfig {
  private Boolean hasMinus;
  private Boolean hasMayus;
  private Boolean hasNumbers;

  private char[] alphabet = "abcdefghijklmnopqrstuvwxy".toCharArray();
  private char[] alphabetMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private Random rand = new Random();
  private int randomLimit = 1000;

  public Boolean getHasMinus() {
    return hasMinus;
  }

  public void setHasMinus(Boolean hasMinus) {
    this.hasMinus = hasMinus;
  }

  public Boolean getHasMayus() {
    return hasMayus;
  }

  public void setHasMayus(Boolean hasMayus) {
    this.hasMayus = hasMayus;
  }

  public Boolean getHasNumbers() {
    return hasNumbers;
  }

  public void setHasNumbers(Boolean hasNumbers) {
    this.hasNumbers = hasNumbers;
  }

  public String shortUrlGenerator() {
    String shortUrlId = "";

    if(this.hasMayus) {
      shortUrlId += this.alphabetMayus[this.rand.nextInt(this.alphabetMayus.length)];
      shortUrlId += this.alphabetMayus[this.rand.nextInt(this.alphabetMayus.length)];
      shortUrlId += this.alphabetMayus[this.rand.nextInt(this.alphabetMayus.length)];
    }

    if(this.hasMinus)  {
      shortUrlId += this.alphabet[this.rand.nextInt(this.alphabet.length)];
      shortUrlId += this.alphabet[this.rand.nextInt(this.alphabet.length)];
      shortUrlId += this.alphabet[this.rand.nextInt(this.alphabet.length)];
    }

    if(this.hasNumbers) {
      shortUrlId += this.rand.nextInt(this.randomLimit) + 1;
    }

    return shortUrlId;
  }

}
