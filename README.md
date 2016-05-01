# Reflections on Java Programming
## Week 1: Introduction and Working with Strings
### A litte Introduction to Regular Expression
Regular Expression is an important concept in Computer Science, I remember that in the course *Logique et langages*, my professor has already taught me how to use regular expressions to determine whether an input string meets a certain standard. For example, in the course project *Systèm de paris sportifs*, I had to write a module to determine whether the password of a new registered user contains only alphabets and numbers. If the password meets the standard, the account of the user will be created, if not, a warning message will be sent to the user. Finally, I had written a regular Expression like *[a-zA-Z]+*. Obviously this is not a practical answer, especially when we compare it with real world password restrictions like that of in social network which require a *password must contain 8 characters and at least one number, one letter and one unique character*.
### A simple way to spilt words from a sentence
The simplest way to split words from a string like *"This is simple test of split string."* is to use the built in method in String data type, namely, **.split(String regex)**. The method takes in regular expression, characters that match the regular expression will be used as delimiters to split the string. For example, if we use **.split(" ")**, the string will be split every time there is a space, as shown below.

#### code snippet
```java
public class SplitStringTest {
	public static void main(String args[]) {
		String test = "This is simple test of split string.";
		String words[] = test.split(" ");
		for (String word: words) {
			System.out.println(word);
		}
	}
}
```

#### output
```console
This
is
simple
test
of
split
string.
```

### An advanced method to spilt a string
The built-in method **.split(String regex)** can split a sentence if we correctly give the delimiter like a white space. However, what if more than one white spaces can be found between the words in that sentence? Like *"This  is simple test of split string."*, then the output will be like below
```console
This

is
simple
test
of
split
string.
```
Clearly, the second output is not what we want. We can solve this problem by further process the output string array. However, we have a more general method to solve this kinds of problem. That is to directly use the regular expression to find strings that we want to match, but we need to follow the following steps:

1. create a String object and put the regular expression in it;
2. create a **Pattern** object and use the class method of **Pattern** class **Pattern.compile(String regex)** to transform the regular expression into the **Pattern** object;
3. create a **Matcher** object and use the instance method of **Pattern** class **.matcher(Sting text)** which will create a **Matcher** object that will match the given input against this pattern;
4. create an array of String to store words that match the regular expression by using the instance method of **Matcher** class **.group()** that returns the matched string once at a time and using the **.find()** method which is used as a loop condition like **.hasNext()** for an ArrayList

#### code snippet
```java
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String args[]) {
		String text = "This is a simple regex test.";
		ArrayList<String> words = new ArrayList<String>();
		String regexExpression = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(regexExpression);
		Matcher match = pattern.matcher(text);
		while (match.find()) {
			words.add(match.group());
		}
		for (String word: words) {
			System.out.println(word);
		}
	}
}
```

#### output
```console
This
is
a
simple
regex
test
```

### More about the Regular Expression
There are three ways to combine a basic regular expression:
1. Repetition: **A** matches character *A*,  **A+** matches one or more character *A*,   **A** matches zero or more character *A*.
2. Concatenation: **AB** matches character *AB*
3. Alternation: **A|B** matches character *A* or character *B*

Besides

- **[]** matches "anything in the set". Ex: **[abc]** matches *a, b or c*
- **[^]** matches "anything NOT in the set". Ex: **[^abc]** matches *Any character except a, b, or c*

It's not easy to remember all the regular expressions, a reference document is necessary when we write this kinds of expressions, [here](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html) is a detailed list of all supported regular expressions in Java SE 7

A website that can check your regular expressions can be found [here](https://regex101.com/), it's really pratical if we want to check if the regular expression fits our needs.


## Week 2 : Efficiency Analysis and Benchmarking

## Week 3 : Interfaces, Linked Lists vs. Arrays, and Correctness

## Week 4 : Trees! (including Binary Search Trees and Tries)

## Week 5 : Hash Maps and Edit Distance

# ANNEX
1. A simple but practical Introduction Markdown can be found [here](https://ruby-china.org/markdown)
2. The full list of languages that supported syntax highlighting in markdown can be found [here](https://support.codebasehq.com/articles/tips-tricks/syntax-highlighting-in-markdown)
