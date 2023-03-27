package spellcheck;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class SpellCheckModule extends AbstractModule {

  @Override
  protected void configure(){
    bind(Dictionary.class).to(TextFileDictionary.class);
    bind(DocumentExtractor.class).to(PlainTextExtractor.class);
    bind(DocumentSource.class).to(URLDocumentSource.class);
  }

  @Provides
  @Named("DictionaryFilePath")
  public String getDictionaryFilePath(){
    return "dict.txt";
  }
}
