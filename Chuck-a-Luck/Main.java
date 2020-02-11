/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7:7 ].
Comment: Yes, I have
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8 ].
Comment: Yes, It does
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5:5 ].
Comment: Yes, it does
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15:15 ]..
Comment: Yes, it does
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20:20 ].
Comment: Yes, it does
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10:10 ].
Comment: Yes, it does

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15:15 ]
Comment: Yes, I do
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: Yes, it does
I ask the user to enter any of the four bet types or quit [Mark out of 5:5 ].
Comment:Yes , I do
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: Yes, it does
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5:5 ]
Comment: Yes, it does

 Total Mark out of 100 (Add all the previous marks): 100
 */



import java.util.Scanner;
public class Main {

	public static final int NOT_INITIALIZED = -1;
	public static final int NUMBER_OF_DICES = 3;
	public static final int PROHIBITED_SCORE_ONE = 3;
	public static final int PROHIBITED_SCORE_TWO = 36;
	public static final int TRIPLE_WIN_MULTIPLIER = 30;
	public static final int FIELD_WIN_MULTIPLIER = 1;
	public static final int HIGH_WIN_MULTIPLIER = 1;
	public static final int LOW_WIN_MULTIPLIER = 1;
	public static final int FIELD_BOUNDARY_ONE = 8;
	public static final int FIELD_BOUNDARY_TWO = 12;
	public static final int HIGH_BOUNDARY = 10;
	public static final int LOW_BOUNDARY = 11;
	public static final String TRIPLE = "TRIPLE";
	public static final String FIELD = "FIELD";
	public static final String HIGH = "HIGH";
	public static final String LOW = "LOW";
	public static final String QUIT = "QUIT";
	public static Scanner input = new Scanner(System.in);

	public static void resolveBet(String bet, Wallet wallet)
	{
		boolean userEnteredCorrectly = false;

		double betAmount = NOT_INITIALIZED;

		while(!userEnteredCorrectly)
		{
			System.out.format("There is %.3f euro left in the wallet, what bet would you like to make ?\n", wallet.check());
			if(input.hasNextDouble())
			{
				betAmount = input.nextDouble();	
				input.nextLine();
				if(betAmount>0&&betAmount<=wallet.check())
				{
					userEnteredCorrectly = true;
				}
			}
			else
			{
				input.nextLine();
			}
		}

		Dice[] dices = new Dice[NUMBER_OF_DICES];

		int sumOfTheDices = 0;

		for(int i = 0; i < dices.length; i++)
		{
			dices[i] = new Dice();
			sumOfTheDices +=dices[i].roll();
		}

		boolean win = false;

		if(bet.equals(TRIPLE))
		{
			if(dices[0].topFace() == dices[1].topFace()&&dices[1].topFace()==dices[2].topFace()&&
					sumOfTheDices !=PROHIBITED_SCORE_ONE&&sumOfTheDices !=PROHIBITED_SCORE_TWO)
			{
				win = true;
				wallet.put((1+TRIPLE_WIN_MULTIPLIER)*betAmount);
			}
			else
			{
				wallet.get(betAmount);
			}
		}
		else if(bet.equals(FIELD))
		{
			if(sumOfTheDices<FIELD_BOUNDARY_ONE||sumOfTheDices>FIELD_BOUNDARY_TWO)
			{
				win = true;
				wallet.put((1+FIELD_WIN_MULTIPLIER)*betAmount);
			}
			else
			{
				wallet.get(betAmount);
			}
		}
		else if(bet.equals(HIGH))
		{
			if(sumOfTheDices>HIGH_BOUNDARY)
			{
				if(!(dices[0].topFace() == dices[1].topFace()&&dices[1].topFace()==dices[2].topFace()))
				{
					win = true;
					wallet.put((1+HIGH_WIN_MULTIPLIER)*betAmount);
				}
			}
			else
			{
				wallet.get(betAmount);
			}
		}
		else if(bet.equals(LOW))
		{
			if(sumOfTheDices<LOW_BOUNDARY)
			{
				if(!(dices[0].topFace() == dices[1].topFace()&&dices[1].topFace()==dices[2].topFace()))
				{
					win = true;
					wallet.put((1+LOW_WIN_MULTIPLIER)*betAmount);
				}
			}
			else
			{
				wallet.get(betAmount);
			}
		}

		if(win)
		{
			System.out.format("You have won, your balance is %.3f\n", wallet.check());
		}
		else
		{
			System.out.format("You have lost, your balance is %.3f\n", wallet.check());
		}

	}

	public static void main(String[] args) 
	{

		boolean userEnteredCorrectly  = false;
		double cash = NOT_INITIALIZED;
		while(!userEnteredCorrectly)
		{
			System.out.print("Please enter the amount of cash you have: ");
			if(input.hasNextDouble())
			{
				cash = input.nextDouble();
				input.nextLine();
				if(cash>0)
				{
					userEnteredCorrectly = true;
				}
			}
			else
			{
				input.nextLine();
			}
		}

		Wallet wallet = new Wallet();

		wallet.put(cash);

		boolean userEnteredQuit = false;

		while(!userEnteredQuit&&wallet.check()>0)
		{
			System.out.print("Please enter TRIPLE, FIELD, HIGH or LOW for the respective game choice or QUIT, so as to leave the game: ");
			String userInput = input.nextLine();
			if(userInput.equals(QUIT))
			{
				userEnteredQuit = true;
			}
			else
			{			
				if(userInput.equals(TRIPLE)||userInput.equals(FIELD)||userInput.equals(HIGH)||userInput.equals(LOW))
				{
					resolveBet(userInput,wallet);
				}
				else
				{
					System.out.println("Incorrect user input. Please Enter again");
				}
			}
		}

		if(wallet.check()>cash)
		{
			System.out.println("You have more money than you had at the start of the game");
		}
		else
		{
			System.out.println("You have less money than you had at the start of the game");
		}

		System.out.format("Your initial money: %.3f, your after game money: %.3f\n",cash,wallet.check());

		input.close();


	}

}
