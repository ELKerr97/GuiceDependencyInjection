package spellcheck.dummyClasses;

import com.google.inject.AbstractModule;
import spellcheck.Dictionary;
import spellcheck.DocumentExtractor;
import spellcheck.DocumentSource;
import spellcheck.dummyClasses.DummyDictionary;
import spellcheck.dummyClasses.DummyDocumentSource;
import spellcheck.dummyClasses.DummyExtractor;

public class FakeModule extends AbstractModule {

  @Override
  protected void configure(){
    bind(Dictionary.class).to(DummyDictionary.class);
    bind(DocumentExtractor.class).to(DummyExtractor.class);
    bind(DocumentSource.class).to(DummyDocumentSource.class);
  }
}
