/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment:	The method returns an ArrayList of Strings and takes no parameters 
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment:	The method opens file "words.txt" and reads all the words from it correctly 
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment:	Yes, the method returns an ArrayList of Strings, which has all the words from the file	

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: The method is defined correctly, it takes no parameters and returns an ArrayList of strings, which are entered
by the user
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: It uses a split method with a special regular expression, so as to separate words and 
return them as an ArrayList of Strings

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment:	The method takes an ArrayList of Strings and returns a boolean
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment:	Yes, it does. It also does that efficiently, by comparing each element only with those 
elements that have a larger index
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment:	It returns false if a non-unique word is found. 
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment:	If just one value is not unique the method immediately returns false, otherwise if all 
values are unique it returns true

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: It takes a String, and determines whether it is an English word (returns a boolean)
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Yes, it does. The binarySearch method returns an integer, which is stored in a special variable.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Yes, it does exactly that.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, it takes two Strings and returns a boolean, identifying whether they are different by one character
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yes, it does exactly that.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment:	Yes, it takes an ArrayList of Strings and determines whether it is a proper word chain by returning a boolean
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: It uses all of the methods listed above, but returns a boolean instead of just printing out the result. 
I think it is more generic. 

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Yes, it does. And that ArrayList is static so that I do not need to run the code for reading words every time 
I need to check if a given String is an English word.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Program does exactly what specified above and the input and output are the same as in the sample.

 Total Mark out of 100 (Add all the previous marks): 100
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
		
		String[] splittedWords = words.split(", *");
			
		if(splittedWords.length==1&&splittedWords[0].equals(""))
		{
			splittedWords = new String[0];
		}
		
		if(splittedWords.length > 0)
		{
			for(int i = 0; i < splittedWords.length; i++)
			{
				int indexOfSpace = splittedWords[i].indexOf(' ');
				if(indexOfSpace>=0)
				{
					splittedWords[i] = splittedWords[i].substring(0, indexOfSpace);
				}
			}
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
				System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
			}
			System.out.println("Enter a comma separated list of words (or an empty list to quit):");
		}		
	}
}
