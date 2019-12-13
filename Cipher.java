/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5
        Comment:  All the variables and constants are correctly formatted

 2. Did I indent the code appropriately?

        Mark out of 5: 5
        Comment:  The indentation is done according to the coding standard 

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment:  The function is defined correctly (signature, body). It is also invoked correctly.

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment: The function is defined correctly (signature, body). It is also invoked correctly.

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20
        Comment: The function is defined correctly (signature, body). It is also invoked correctly.

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25: 25
        Comment: Main works correctly. It takes the value from user, prints the mapping, encrypted string and the result of decrypting

 7. How well did I complete this self-assessment?

        Mark out of 5: 5
        Comment: Self - assessment helped me to improve the code. 
 
 Total Mark out of 100 (Add all the previous marks): 100

 */ 

import java.util.Random;
import java.util.Scanner;
public class Cipher 
{
	
	public static final int NUMBER_OF_SYMBOLS = 27;
	public static final String ALPHABET = "a b c d e f g h i j k l m n o p q r s t u v w x y z ";

	public static char[] createCipher()
	{
		char[] mapping = new char[NUMBER_OF_SYMBOLS];
		int currentIndex  = 0;
		for(char currentChar = 'a';currentChar<='z';currentChar++)
		{
			mapping[currentIndex++] = currentChar;
		}

		mapping[currentIndex] = ' ';

		Random rnd = new Random();
		for(int index = 0; index<NUMBER_OF_SYMBOLS;index++)
		{
			int randomIndex = rnd.nextInt(NUMBER_OF_SYMBOLS);
			char temporaryChar = mapping[index];
			mapping[index] = mapping[randomIndex];
			mapping[randomIndex] = temporaryChar;
		}

		return mapping;
	}

	public static String encrypt(char [] phrase, char [] mapping)
	{
		if(phrase!=null&&mapping!=null)
		{
			if(mapping.length==NUMBER_OF_SYMBOLS)
			{
				char [] encryptedPhrase = new char[phrase.length];
				for(int currentIndex = 0; currentIndex < phrase.length; currentIndex++)
				{
					if(phrase[currentIndex]>='a'&&phrase[currentIndex]<='z')
					{
						encryptedPhrase[currentIndex] = mapping[phrase[currentIndex] -'a'];
					}
					else if(phrase[currentIndex] == ' ')
					{
						encryptedPhrase[currentIndex] = mapping[NUMBER_OF_SYMBOLS - 1];
					}
				}
				return new String(encryptedPhrase);
			}

		}
		return new String();

	}

	public static String decrypt(char [] encryptedPhrase, char [] mapping)
	{
		if(encryptedPhrase!=null&&mapping!=null)
		{
			if(mapping.length==NUMBER_OF_SYMBOLS)
			{
				char [] decryptedPhrase = new char [encryptedPhrase.length];
				for(int currentIndex = 0; currentIndex < encryptedPhrase.length;currentIndex++)
				{

					int encryptionIndex = new String(mapping).indexOf(encryptedPhrase[currentIndex]);

					if(encryptionIndex != NUMBER_OF_SYMBOLS - 1)
					{
						decryptedPhrase[currentIndex] = (char)(encryptionIndex + 'a');
					}
					else
					{
						decryptedPhrase[currentIndex] = ' ';
					}
				}
				return new String(decryptedPhrase);

			}
		}
		return new String();
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

		boolean userEnteredExit = false;

		while(!userEnteredExit)
		{
			System.out.print("Please enter a phrase you want to encrypt (or '-exit', if you want to stop): ");

			if(!input.hasNext("-exit"))
			{
				String phrase = input.nextLine().toLowerCase();

				System.out.println("Here is the randomly generated mapping: ");
				System.out.println(ALPHABET);

				char [] mapping = createCipher();
				for(int index = 0 ; index < NUMBER_OF_SYMBOLS; index++)
				{

					System.out.format("%c ", mapping[index]);

				}
				System.out.println();

				String encryptedPhrase = encrypt(phrase.toCharArray(), mapping);

				System.out.println("Here is the encrypted phrase:");
				System.out.println(encryptedPhrase);

				System.out.println("Here is the decrypted phrase:");
				System.out.println(decrypt(encryptedPhrase.toCharArray(), mapping));
			}
			else
			{
				userEnteredExit = true;
			}
		}

		input.close();
	}
}
