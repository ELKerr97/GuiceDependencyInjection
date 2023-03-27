package spellcheck.dummyClasses;

import spellcheck.DocumentSource;

import java.io.IOException;

public class DummyDocumentSource implements DocumentSource {
  @Override
  public String getContent(String uri) throws IOException {
    return null;
  }
}
