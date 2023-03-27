package spellcheck;

import java.util.List;

public interface DocumentExtractor {
  List<String> extract(String content);
}
