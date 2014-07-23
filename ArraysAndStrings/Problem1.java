package ArraysAndStrings;

import org.junit.Assert;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Problem statement:
 * 
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 * 
 * Assumption: uppercase and lower case are different characters (e.g. A is different from a)
 * 
 * 
 * @author Ankit Patel
 *
 */
public class Problem1 {
	
	
	/**
	 * O(n) solution using an array.
	 * 
	 * We can assume that the characters are ASCII characters and create a array of 128 length
	 * and as we iterate through each character, we set the ASCII value of the character to true.
	 * If we run across one that is already set, we know it's a repeat, and we can return false
	 * 
	 * 
	 * @param str Input string
	 * @return True if all characters in the input string are unique, False otherwise
	 */
	public static boolean containsUniqueCharacters(String str){
		
		boolean [] ASCIIMapping = new boolean[128];
		
		for(int i=0; i<str.length();i++){
			int currCharAsciiValue = str.charAt(i);
			if(ASCIIMapping[currCharAsciiValue]){
				return false;
			}
			ASCIIMapping[currCharAsciiValue] = true;
		}
		
		return true;
		
	}
	
	/**
	 * O(2n) solution using hash map.
	 * 1. Iterate through the characters in the string and store into hashmap where the key
	 * 		is the character and value is the # of occurances
	 * 2. Iterate through the hashmap values and if all the values are 1, then all characters
	 * 		in the string are unique, otherwise they are not
	 * 
	 * @param str Input string
	 * @return True if all characters in the input string are unique, False otherwise
	 */
	public static boolean containsUniqueCharacters2(String str){
		

		HashMap<Character, Integer> charOccurances = new LinkedHashMap<Character, Integer>();
		
		for(int i=0; i<str.length();i++){
			char currChar = str.charAt(i);
			
			//if already in hashmap, update value, otherwise add it
			if(charOccurances.containsKey(currChar)){
				int currCount = charOccurances.get(currChar);
				charOccurances.put(currChar, currCount+1);
			}else{
				charOccurances.put(currChar, 1);
			}
		}
		
		Iterator<Map.Entry<Character, Integer>> it = charOccurances.entrySet().iterator();
		while(it.hasNext()){
			if (it.next().getValue() > 1){
				System.out.println(str + " DOES NOT contain unique characters");
				return false;
			}
		}
		System.out.println(str + " contains unique characters");		
		return true;
	}

	/**
	 * 0(n^2) solution without anything any additional data structures
	 * 
	 * Algorithm: For each character in the string, compare it with all the other characters in the string
	 *				and if another of the same character exists, then returns false. Otherwise, if no match
	 *				any of the characters are found, return true.
	 * 
	 * @param str Input string
	 * @return True if all characters in the input string are unique, False otherwise
	 */
	public static boolean containsUniqueCharactersNoDataStructures(String str){
		
		
		for(int i=0; i<str.length(); i++){
			char currChar = str.charAt(i);
 
			for(int j=i+1; j<str.length(); j++){
				if (currChar == str.charAt(j)){
					System.out.println(str + " DOES NOT contain unique characters");
					return false;
				}
				
			}
		}
		
		System.out.println(str + " contains unique characters");
		return true;
	}
	
	
	/**
	 * Testing
	 */
	public static void main(String[] args) {
		
		//Testing algorithm using ASCII mapping array
		Assert.assertFalse(Problem1.containsUniqueCharacters("He1lo World"));
		Assert.assertFalse(Problem1.containsUniqueCharacters("ABCA123"));
		Assert.assertTrue(Problem1.containsUniqueCharacters("abcdefg"));
		Assert.assertTrue(Problem1.containsUniqueCharacters(""));
		Assert.assertTrue(Problem1.containsUniqueCharacters("AaBbCc"));
		Assert.assertTrue(Problem1.containsUniqueCharacters("1234567890"));
		Assert.assertTrue(Problem1.containsUniqueCharacters("!@#$%^&*()_+|}{:?><,./;[]=-"));
		Assert.assertFalse(Problem1.containsUniqueCharacters("!@#$%^&*()_+|}{:?><,./;[]]=-"));
		
		
		//Testing algorithm using hashmap data structure
		Assert.assertFalse(Problem1.containsUniqueCharacters2("He1lo World"));
		Assert.assertFalse(Problem1.containsUniqueCharacters2("ABCA123"));
		Assert.assertTrue(Problem1.containsUniqueCharacters2("abcdefg"));
		Assert.assertTrue(Problem1.containsUniqueCharacters2(""));
		Assert.assertTrue(Problem1.containsUniqueCharacters2("AaBbCc"));
		Assert.assertTrue(Problem1.containsUniqueCharacters2("1234567890"));
		Assert.assertTrue(Problem1.containsUniqueCharacters2("!@#$%^&*()_+|}{:?><,./;[]=-"));
		Assert.assertFalse(Problem1.containsUniqueCharacters2("!@#$%^&*()_+|}{:?><,./;[]]=-"));
		
		
		//Testing algorithm using no additional data structure
		Assert.assertFalse(Problem1.containsUniqueCharactersNoDataStructures("He1lo World"));
		Assert.assertFalse(Problem1.containsUniqueCharactersNoDataStructures("ABCA123"));
		Assert.assertTrue(Problem1.containsUniqueCharactersNoDataStructures("abcdefg"));
		Assert.assertTrue(Problem1.containsUniqueCharactersNoDataStructures(""));
		Assert.assertTrue(Problem1.containsUniqueCharactersNoDataStructures("AaBbCc"));
		Assert.assertTrue(Problem1.containsUniqueCharactersNoDataStructures("1234567890"));
		Assert.assertTrue(Problem1.containsUniqueCharactersNoDataStructures("!@#$%^&*()_+|}{:?><,./;[]=-"));
		Assert.assertFalse(Problem1.containsUniqueCharactersNoDataStructures("!@#$%^&*()_+|}{:?><,./;[]]=-"));
		
	}

}
