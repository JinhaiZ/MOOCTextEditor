package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
	public DictionaryLL(){
		this.dict = new LinkedList<String>();
	}


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	String low = word.toLowerCase();
    	for (String w: this.dict) {
    		if (w.equalsIgnoreCase(word))
    			return false;
    	}
    	dict.add(low);
        return true;
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
    	for (String word: dict) {
    		if(word.equalsIgnoreCase(s)) {
    			return true;
    		}
    	}
        return false;
    }

    
}
