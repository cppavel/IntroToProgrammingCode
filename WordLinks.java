/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:]
- Comment: 
- My method reads the words from the "words.txt" file. [Mark out of 5:]
- Comment: 
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:]
- Comment: 

2. readWordList
- I have the correct method definition [Mark out of 5:]
- Comment: 
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:]
- Comment: 

3. isUniqueList
- I have the correct method definition [Mark out of 5:]
- Comment: 
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:]
- Comment: 
- Exits the loop when a non-unique word is found. [Mark out of 5:]
- Comment: 
- Returns true is all the words are unique and false otherwise. [Mark out of 5:]
- Comment: 

4. isEnglishWord
- I have the correct method definition [Mark out of 5:]
- Comment: 
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:]
- Comment: 
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:]
- Comment: 

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:]
- Comment: 
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:]
- Comment: 

6. isWordChain
- I have the correct method definition [Mark out of 5:]
- Comment: 
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:]
- Comment: 

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:]
- Comment: 
- Asks the user for input and calls isWordChain [Mark out of 5:]
- Comment: 

 Total Mark out of 100 (Add all the previous marks):
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
public class WordLinks 
{
	public static final String FILE_NAME = "words.txt";
	public static final int NUMBER_OF_LETTERS_ALPHABET = 26;

	public static ArrayList<String> ENGLISH_WORDS;
	
	public static ArrayList<String> readDictionary() throws Exception
	{
		FileReader fr = new FileReader(FILE_NAME);
		BufferedReader input = new BufferedReader(fr);
		
		ArrayList<String> returnValue =new ArrayList<String>();
		
		String line;
		while((line=input.readLine())!=null)
		{
			returnValue.add(line);
		}
	
		input.close();
		fr.close();
		
		return returnValue;					
	}
	
	public static ArrayList<String> readWordList() throws Exception
	{
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(stream);
		
		String words = input.readLine().toLowerCase();
		
		String[] splittedWords = words.split(",[^a-z]?");
			
		if(splittedWords.length==1&&splittedWords[0].equals(""))
		{
			splittedWords = new String[0];
		}
		
		ArrayList<String> returnValue = new ArrayList<String>();
		
		for(int i = 0 ;i < splittedWords.length; i++)
		{
			returnValue.add(splittedWords[i]);
		}
		
		return returnValue;
		
	}
	
	public static boolean isUniqueList (ArrayList<String> words)
	{
		for(int i = 0; i < words.size(); i++)
		{
			for(int j = i + 1; j < words.size(); j++)
			{
				if(words.get(i).equals(words.get(j)))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean isEnglishWord (String word)
	{
		if(Arrays.binarySearch(ENGLISH_WORDS.toArray(), word)>=0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean isDifferentByOne(String wordOne, String wordTwo)
	{
		if(wordOne.length() == wordTwo.length())
		{
			
			int counter = 0; 
			for(int i = 0; i< wordTwo.length(); i++)
			{
				if(wordOne.charAt(i)!=wordTwo.charAt(i))
				{
					counter++;
				}
			}
			
			if(counter == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isWordChain(ArrayList<String> chain)
	{
		if(isUniqueList(chain)&&chain.size()>=2)
		{
			for(int i = 0; i < chain.size()-1;i++)
			{
				if(isEnglishWord(chain.get(i))&&isEnglishWord(chain.get(i+1)))
				{
					if(!isDifferentByOne(chain.get(i),chain.get(i+1)))
					{
						return false;
					}
				}
				else
				{
					return false;
				}						
			}
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	public static void main(String [] args) throws Exception
	{
		ENGLISH_WORDS = readDictionary();
		ArrayList<String> words;
		System.out.println("Enter a comma separated list of words (or an empty list to quit):");
		while((words = readWordList()).size()!=0)
		{
			if(isWordChain(words))
			{
				System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
			}
			else
			{
				System.out.println("Not a valid chain of words from Lewis Carroll's word-links game");
			}
			System.out.println("Enter a comma separated list of words (or an empty list to quit)");
		}
		
	}
}
