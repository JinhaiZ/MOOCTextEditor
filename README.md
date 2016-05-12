# Reflections on Java Programming
## Week 1: Introduction and Working with Strings
### A little Introduction to Regular Expression
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

A website that can check your regular expressions can be found [here](https://regex101.com/), it's really practical if we want to check if the regular expression fits our needs.


## Week 2 : Efficiency Analysis and Benchmarking

### A small introduction to JUnit in Eclipse

There is a simple way to do unit test for Java in Eclipse, that is JUnit. The first time that I used JUnit, I was amazed by its simplicity and efficiency. As part of the assignment of the project *Fil Rough* in the module INF 301, I've wrote test cases to see whether units of the back-end of a betting system works well. At the same time, our professor also use the JUnit as a way to measure the results our solution. Before I learned how to use JUnit, writing a main method after the class that I want to test was really a repetitive and boring task. However, with the help of JUnit, I can write all the test case in a same place, what's more, I can have more control over the code that I've written.

### JUnit in Eclipse

Firstly, to use JUnit, JUnit packages needs to be loaded, so
```java
import org.junit
```
needs to be written as first line in our test class.
Below is a concrete example of how we use JUnit to do unit test.

```java
import java.util.LinkedList;

import org.junit.*;

public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;

	/**
	 * run every time before each test
	 */
	@Before
	public void setUp() throws Exception {
		// Initialize 2 list for the following test
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
	}

	/**
	 * run only one time before test
	 */
	@BeforeClass
	public void setUpClass()
	{
	}

	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
			//System.out.println("Check out of bounds" + " - failed");
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
	}

	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
	}

	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
	}

	/** Test the size of the list */
	@Test
	public void testSize()
	{
	}

	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
	}

	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	}

	/**
	 * run every time after each test
	 */
	@After
	public void tearDown()
	{
	}

	/**
	 * run every only one time after test
	 */
	@AfterClass
	public void tearDownClass()
	{
	}

}
```

For the basic use of JUnit, 5 annotations needs to be learned, namely *@Before, @BeforeClass, @test, @After and @AfterClass*. Here are the signatures

```java
@Before
public void setUp() throws Exception
{
	// is run before each test to initialize variables and objects
}

@BeforeClass
public static void setUpBeforeClass() throws Exception
{
	// is run only once before the class to initialize objects
}

@test
public void test<feature>()
{
	/* <feature> denotes a feature that we want to test
	* if we want to test Remove method of the class
	* the method name can be testRemove()
	*/

}

@After
public void tearDown() throws Exception
{
	/* This method can be useful if your test constructed something which needs
	* to be properly torn down, for example, the database
	*/
}

@AfterClass
public static void tearDownAfterClass() throws Exception
{
	/* This method can be useful if your setUpClass() method constructed something
	*  which needs to be properly torn down, for example, the database
	*/
}
```

We notice that *@Before, @BeforeClass, @After and @AfterClass* are help method that help us to setup and clean the test environment, the most important is *@test*, there are serveral ways to test a method of a class, for the basic use of JUnit, we need at least know the following 2 method.

#### To test corner cases
we can test corner cases by using **fail()** method, here the method that we want to test is *emptyList.get(0);*. As we know, we can not get element from an empty list, *emptyList.get(0);* should throw an exception. However, if no exceptions are thrown during this method, **fail()** method would be called to let us know the *emptyList.get(0);* must has something wrong .

```java
try {
			emptyList.get(0);
			fail("Check out of bounds");
			//System.out.println("Check out of bounds" + " - failed");
		}
		catch (IndexOutOfBoundsException e) {
			//System.out.println("Check out of bounds" + " - passed");
```

#### To test common cases

we can use **assertEquals()** to test common cases, **assertEquals()** takes 3 input, the first is a Sting, test message can be written here to let us know which test is runned, the second is expected value, the third is actual value that we get from the method that we want to test.

```java
// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
```

So in this way, we can test if the output of a certain method meets our expectation, if the expected value doesn't equal to the actual value, we can get a failure from JUnit control board. The signature of **assertEquals()** are shown below

```java
assertEquals(java.lang.String message, long expected, long actual)
				Asserts that two longs are equal
```

## Week 3 : Interfaces, Linked Lists vs. Arrays, and Correctness

## Week 4 : Trees! (including Binary Search Trees and Tries)

## Week 5 : Hash Maps and Edit Distance

# ANNEX
1. A simple but practical Introduction Markdown can be found [here](https://ruby-china.org/markdown)
2. The full list of languages that supported syntax highlighting in markdown can be found [here](https://support.codebasehq.com/articles/tips-tricks/syntax-highlighting-in-markdown)
3. JUnit API can be found [here](http://junit.sourceforge.net/javadoc/org/junit/package-summary.html)
