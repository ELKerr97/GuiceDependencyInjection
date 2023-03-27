package spellcheck.dummyClasses;

import spellcheck.Dictionary;

public class DummyDictionary implements Dictionary {
  @Override
  public boolean isValidWord(String word) {
    return false;
  }
}
