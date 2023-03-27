
package spellcheck;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SpellingChecker {

  private final DocumentSource documentSource;
  private final DocumentExtractor documentExtractor;
  private final Dictionary dictionary;

  // todo: add "inject" to this constructor
  @Inject
  public SpellingChecker(DocumentSource documentSource, DocumentExtractor documentExtractor, Dictionary dictionary) {
    this.documentSource=documentSource;
    this.documentExtractor=documentExtractor;
    this.dictionary=dictionary;
  }

  public SortedMap<String, Integer> check(String uri) throws IOException {

          // download the document content
          //
          String content = documentSource.getContent(uri);

          // extract words from the content
          //
          List<String> words = documentExtractor.extract(content);

          // find spelling mistakes
          //
          SortedMap<String, Integer> mistakes = new TreeMap<>();

      for (String word : words) {
          if (!dictionary.isValidWord(word)) {
              if (mistakes.containsKey(word)) {
                  int oldCount = mistakes.get(word);
                  mistakes.put(word, oldCount + 1);
              } else {
                  mistakes.put(word, 1);
              }
          }
      }

          return mistakes;
    }
}

