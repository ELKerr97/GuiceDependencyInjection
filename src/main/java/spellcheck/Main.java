
package spellcheck;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
			// todo: add another dummy module for testing
			Injector injector = Guice.createInjector(new SpellCheckModule());
			SpellingChecker spellingChecker = injector.getInstance(SpellingChecker.class);
			SortedMap<String, Integer> mistakes = spellingChecker.check(args[0]);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

