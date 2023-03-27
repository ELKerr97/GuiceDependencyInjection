package spellcheck.dummyClasses;

import spellcheck.DocumentExtractor;

import java.util.ArrayList;
import java.util.List;

public class DummyExtractor implements DocumentExtractor {
  @Override
  public List<String> extract(String content) {
    return new ArrayList<>();
  }
}
