package reflections;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String args[]) {
		String text = "This is a simple regex test.";
		String regexExpression = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(regexExpression);
		Matcher match = pattern.matcher(text);
		ArrayList<String> words = new ArrayList<String>();
		while (match.find()) {
			words.add(match.group());
		}
		for (String word: words) {
			System.out.println(word);
		}
	}
}