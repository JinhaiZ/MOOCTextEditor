/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		//System.out.println(shortList);
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
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
		catch (IndexOutOfBoundsException e) {
			//System.out.println("Check out of bounds" + " - passed");
			
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		assertEquals("Remove: check element 0 is correct ","B", shortList.remove(1));
		assertEquals("Remove: check element 0 is correct ",1, shortList.size());
		assertEquals("Remove: check element 0 is correct ","A", shortList.remove(0));
		System.out.println(longerList);
		assertEquals("Remove: check element 0 is correct ",(Integer)4, longerList.remove(4));
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// test empty list
		try {
			emptyList.add(null);
			fail("null element added");
		} 
		catch(NullPointerException e) {
			
		}
		// test short list
		assertEquals("AddEnd: check return is correct ", true, shortList.add("C"));
		assertEquals("AddEnd: check size is correct ", 3, shortList.size);
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// test empty list
		assertEquals("AddEnd: check return is correct ", 0, emptyList.size());
		// test short list
		assertEquals("AddEnd: check return is correct ", 2, shortList.size());
		shortList.add("C");
		assertEquals("AddEnd: check size is correct ", 3, shortList.size());
		shortList.remove(0);
		assertEquals("AddEnd: check size is correct ", 2, shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// test empty list
		try {
			emptyList.add(-1,0);
			fail("Check out of bounds");
		} 
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			emptyList.add(1,0);
			fail("Check out of bounds");
		} 
		catch(IndexOutOfBoundsException e) {
			
		}
		// test short list
		try {
			shortList.add(0,null);
			fail("Check null element");
		} 
		catch(NullPointerException e) {
			
		}
		try {
			shortList.add("C");
		} 
		catch(NullPointerException e) {
			fail("Check null element");
		}
		assertEquals("AddEnd: check return is correct ", "C", shortList.get(2));
		
		// test off the end of the longer array
		try {
			longerList.add(-1,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.add(LONG_LIST_LENGTH+1,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		// test empty list
		try {
			emptyList.set(-1,0);
			fail("Check out of bounds");
		} 
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			emptyList.set(1,0);
			fail("Check out of bounds");
		} 
		catch(IndexOutOfBoundsException e) {
			
		}
		// test short list
		assertEquals("AddEnd: check return is correct ", "B", shortList.set(1,"C"));
		assertEquals("AddEnd: check size is correct ", "C", shortList.get(1));
		
		// test off the end of the longer array
		try {
			longerList.set(-1,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.set(LONG_LIST_LENGTH,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	    
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
