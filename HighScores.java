import java.util.Scanner;
public class HighScores 
{

	public static void initializelHighScores(int [] highScores)
	{
		if(highScores!=null)
		{
			for(int index = 0; index < highScores.length; index++)
			{
				highScores[index]  = 0;
			}
		}
	}

	public static void printHighScores(int [] highScores)
	{
		if(highScores!=null)
		{
			System.out.print("High scores are: ");
			int index = 0;
			while(index<highScores.length&&highScores[index]!=0)
			{
				System.out.format("%d ", highScores[index]);
				index++;
			}

			System.out.println();

		}
	}

	public static boolean higherThan(int highScore, int [] highScores)
	{
		if(highScores!=null&&highScores.length!=0)
		{
			return highScore>highScores[0];
		}
		else
		{
			return false;
		}
	}

	public static void insertScore(int highScore, int [] highScores)
	{
		if(highScores!=null)
		{
			for(int i = highScores.length-1;i>=1;i--)
			{
				highScores[i] = highScores[i-1];
			}
			highScores[0] = highScore;
		}
	}



	public static void main(String[] args) 
	{
		System.out.println("How many high scores do you want to maintain?");

		Scanner input = new Scanner(System.in);

		while(!input.hasNextInt())
		{
			input.nextLine();
			System.out.println("Please enter a positive integer");
		}

		int numberOfHighScores = input.nextInt();
		input.nextLine();

		int[] highScores = new int[numberOfHighScores];

		initializelHighScores(highScores);

		boolean finish  = false;

		while (!finish)
		{
			System.out.println("Enter the current score or \"exit\"");

			while(!input.hasNextInt()&&!input.hasNext("exit"))
			{
				input.nextLine();
				System.out.println("Enter the current score or \"exit\"");
			}

			if(input.hasNextInt())
			{
				int currentScore = input.nextInt();

				if(higherThan(currentScore,highScores))
				{
					insertScore(currentScore, highScores);
				}

				printHighScores(highScores);

				input.nextLine();
			}
			else if(input.hasNext("exit"))
			{
				finish = true;
			}
		}

		input.close();



	}

}
