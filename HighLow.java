/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment:  Yes, I did. All the required values are stored as constants.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: Yes, I did. All the constants' names are straightforward and are formatted correctly. 
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment: Yes, I did. All the variables' names are straightforward.
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
       Comment: Yes, I did. All the variables' names are formatted correctly.
   5. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: Yes, I did. I indented the code, so it is easy to read it.
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20: 20 
       Comment: Yes, I did. The program does exactly what is written above.
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10: 10
       Comment: Yes, I did. If the incorrect input is entered, the program throws an exception, which is then handled.
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 10
       Comment: Yes, I did. I used "Random" class object for that.
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 10
       Comment:  Yes, I did. I created a special function for that.
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10: 10
       Comment:  Yes, I did. The user is informed whether they won or not after the game.
   11. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment:  I honestly assessed my program. Self-assessment helped me to improve the quality of my program.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;
import java.util.Random;
public class HighLow 
{

	public static final int NUMBER_OF_GAMES_TO_WIN = 4;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 14;
	public static final int MAX_FOR_RND_GENERATOR = 13;
	public static final int ADD_FOR_RND_GENERATOR = 2;


	public static void printCard(int currentCard)
	{
		if(currentCard<JACK)
		{
			System.out.format("The card is a %d.",currentCard);
		}
		else
		{
			switch(currentCard)
			{
			case JACK: 
				System.out.format("The card is a Jack."); break;
			case QUEEN:
				System.out.format("The card is a Queen."); break;
			case KING: 
				System.out.format("The card is a King."); break;
			case ACE: 
				System.out.format("The card is a Ace."); break;
			default: 
				System.out.format("Error"); break;
			}
		}

	}

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		Random randomGenerator = new Random();
		int currentCard = randomGenerator.nextInt(MAX_FOR_RND_GENERATOR) + ADD_FOR_RND_GENERATOR;

		int winsInRow = 0;
		
		boolean isGameFinished  = false;
		
		boolean isUserWinner = false;

		while(!isGameFinished)
		{
			try 
			{

				printCard(currentCard);
				System.out.format("\nDo you think the next card will be higher, lower or equal?");
				String userGuess = input.next();
				int nextCard = randomGenerator.nextInt(MAX_FOR_RND_GENERATOR) + ADD_FOR_RND_GENERATOR;;

				if((userGuess.equals("higher")&&(nextCard>currentCard))||
						(userGuess.equals("lower")&&(nextCard<currentCard))||
							(userGuess.equals("equal")&&(nextCard==currentCard)))
				{					
					winsInRow++;
					
					if(winsInRow == NUMBER_OF_GAMES_TO_WIN)
					{
						isGameFinished = true;
						isUserWinner = true;
					}
				}
				else if(userGuess.equals("higher")||userGuess.equals("lower")||userGuess.equals("equal"))
				{
					isGameFinished = true;
					isUserWinner = false;
				}
				else
				{
					throw new Exception("Incorrect input.\n");
				}
				currentCard = nextCard;
			}
			catch(Exception error)
			{
				System.err.format("An error occured: " + error.getMessage());
			}		
		}	
		printCard(currentCard);
		if(isUserWinner)
		{
			System.out.format("\nCongratulations. You got them all correct.\n");
		}
		else
		{
			System.out.format("\nYou lost that game.\n");
		}
		input.close();


	}
}
