package reflections;

public class SplitStringTest {
	public static void main(String args[]) {
		String test = "This is simple test of split string.";
		String words[] = test.split(" ");
		for (String word: words) {
			System.out.println(word);
		}
	}
}
