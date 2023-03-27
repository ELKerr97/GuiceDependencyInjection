import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spellcheck.SpellCheckModule;
import spellcheck.SpellingChecker;
import spellcheck.dummyClasses.FakeModule;

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.SortedMap;

public class SpellingCheckerTests {

  private SpellingChecker spellingCheckerUnderTest;
  private SpellingChecker dummySpellingCheckerUnderTest;
  private Injector injector;
  private Injector dummyInjector;
  private String uri;

  @BeforeEach
  public void setUp(){
    injector = Guice.createInjector(new SpellCheckModule());
    dummyInjector = Guice.createInjector(new FakeModule());
    spellingCheckerUnderTest = injector.getInstance(SpellingChecker.class);
    dummySpellingCheckerUnderTest = dummyInjector.getInstance(SpellingChecker.class);
    uri = "https://pastebin.com/raw/t6AZ5kx3";
  }

  @Test
  void should_catchErrors_when_givenValidURI() throws IOException {
    Assertions.assertNotNull(spellingCheckerUnderTest.check(uri));
  }

  @Test
  void should_haveNoMistakes_when_givenDummyInjector() throws IOException {
    SortedMap<String, Integer> result;
    result = dummySpellingCheckerUnderTest.check(uri);
    Assertions.assertTrue(result.isEmpty());
  }
}
