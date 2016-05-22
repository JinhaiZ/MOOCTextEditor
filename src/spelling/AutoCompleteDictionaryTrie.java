package spelling;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;


    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
		this.size = 0;
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
		String low = word.toLowerCase();
		TrieNode current = root;
		int length = word.length();
		int count = 0;
	    for (Character c : low.toCharArray()) {
	    	TrieNode next = current.insert(c);
	    	if(next == null) {
	    		next = current.getChild(c);
	    		if (count == length -1 && next.endsWord())
	    			return false;   			
	    	}
	    	current = next;
	    	count++;
	    }
	    current.setEndsWord(true);
	    this.size ++;
	    return true;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    return this.size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
	    String low = s.toLowerCase();
	    TrieNode current = root;
	    for (Character c : low.toCharArray()) {
	    	current = current.getChild(c);
	    	if (current == null)
	    		return false;
	    	
	    }
	    if (s.length()>0 && current.endsWord())
	    	return true;
	    else
	    	return false;
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 List<String> completions = new ArrayList<String>();
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 TrieNode stem = root;
    	 if (numCompletions == 0)
    		 return completions;
    	 
    	 for (Character c: prefix.toCharArray()) {
    		 stem = stem.getChild(c);
    		 if (stem == null) {
    			 return completions;
    		 }
    	 }
    	 if (prefix.length() == 0)
    		 stem = root;
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 Queue<TrieNode> queue = new LinkedList<TrieNode>();
    	 queue.add(stem);
    	 TrieNode current;
    	 while(!queue.isEmpty()) {
    		 if (completions.size() < numCompletions){
    			 current = queue.poll();
    			 // Visted
    			 if (current.endsWord()) {
    				 completions.add(current.getText());
    			 }
    			 Set<Character> childrens = current.getValidNextCharacters();
    			 for (Character c: childrens) {
    				 //System.out.println("size of set--"+childrens.size());
    				 TrieNode newNode = current.getChild(c);
    				 //System.out.println("current--"+current.getText());
    				 if (newNode != null)
    					 queue.add(newNode);
    			 }
    		 }
    		 else
    			 return completions;
    	 }
    	 return completions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}