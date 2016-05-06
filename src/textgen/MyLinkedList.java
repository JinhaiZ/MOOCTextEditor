package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null,head);
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) throw new NullPointerException("element is null");
		LLNode<E> node = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
		prev.next = node;
		node.next = tail;
		node.prev = prev;
		tail.prev = node;
		this.size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index<0||index>=size)throw new IndexOutOfBoundsException("index is out of bound");
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (index<0||index>=size)throw new IndexOutOfBoundsException("index is out of bound");
		if (element == null) throw new NullPointerException("element is null");
		LLNode<E> prev = head;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		LLNode<E> node = new LLNode<E>(element);
		
		node.next = prev.next;
		prev.next = node;
		node.next.prev = node;
		node.prev = prev;
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index<0||index>=size)throw new IndexOutOfBoundsException("index is out of bound");
		LLNode<E> prev = head;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		LLNode<E> remove = prev.next;
		remove.next.prev = prev;
		prev.next = remove.next;
		this.size--;

		return remove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index<0||index>=size)throw new IndexOutOfBoundsException("index is out of bound");
		if (element == null) throw new NullPointerException("element is null");
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		E original = node.data;
		node.data = element;
		return original;
	} 
	
	public String toString(){
		LLNode<E> node = head;
		for (int i = 0; i < size; i++) {
			node = node.next;
			System.out.println("Node["+i+"] = "+node.data);
		}
		return null;
		
	} 	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e,LLNode<E> prev)
	{
		this.data = e;
		prev.next = this;
		this.prev = prev;
		this.next = null;
	}

}
