package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
 
 	// You'll need a constructor here
   public DictionaryBST(){
	   this.dict = new TreeSet<String>();
   }
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	String low = word.toLowerCase();
        return this.dict.add(low);
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	if (this.dict != null)
    		return this.dict.size();
    	else
    		return 0;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	String low = s.toLowerCase();
        return this.dict.contains(low);
    }

}
