/* SELF ASSESSMENT

Connect4Game class (35 marks): 35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. 
If the user decides to play then: 
1. Connect4Grid2DArray is created using the Connect4Grid interface, 
2. the two players are initialized - must specify the type to be ConnectPlayer, and 3. the game starts. 
In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. 
Finally a check is performed to determine a win. 
Comment: The class creates references to two ConnectPlayers and a grid. It also asks the user if they want to play or not repeatedly.
If the user decided to play, the grid is created and two players objects are created and assigned to ConnectPlayer references. The game then starts.
It is also to say that user has 3 options: Play against other human, play against AI and simulate the game of two AIs.

Connect4Grid interface (10 marks): 10
I define all 7 methods within this interface.
Comment: Obviously, I do as program will not compile otherwise. 

Connect4Grid2DArray class (25 marks): 25
My class implements the Connect4Grid interface. It creates a grid using a 2D array.
Implementation of the method to check whether the column to drop the piece is valid. 
It provides an implementation of the method to check whether the column to drop the piece is full. 
It provides an implementation of the method to drop the piece.  
It provides an implementation of the method to check whether there is a win.
Comment: Firstly, yes it provides all the implementations of the methods required by Connect4Grid Interface. Secondly, I use an efficient way of tracking whether the
column is full or not by using an additional array of the current valid positions in the columns.

ConnectPlayer abstract class (10 marks): 10
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: Well, yes. It has a toString method as well as tryParse, which are not abstract and several getters/setters which are also not abstract.
Finally, there is an abstract method called decideWhereToDrop().

C4HumanPlayer class (10 marks): 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: Yes, it extends the ConnectPlayer class. It also provides functionality for the human player (inputting the required position, checking whether it is valid and adding
the disc)

C4RandomAIPlayer class (10 marks): 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: Yes, it extends the ConnectPlayer class. It also provides functionality for the AI player. Choosing a valid column randomly and adding the disc.

Total Marks out of 100: 100

 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Connect4Game 
{
	public static final int RED = 1;
	public  static final int YELLOW = 2;
	public  static final int PLAYER_ONE = 0;
	public  static final int PLAYER_TWO = 1;

	public static void main(String [] args) throws Exception
	{
		

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean userEnteredQuit = false;
		while (!userEnteredQuit)
		{	
			boolean enteredCorrectly = false;
			while(!enteredCorrectly)
			{
				System.out.println("Do you want to play or quit. Enter play/quit:");
				String line = input.readLine();
				if(line.equals("quit"))
				{
					userEnteredQuit = true;
					enteredCorrectly = true;
				}
				else if(line.equals("play"))
				{
					enteredCorrectly = false;
					ConnectPlayer  playerOne = null;
					ConnectPlayer  playerTwo = null;
					Connect4Grid2DArray grid = new Connect4Grid2DArray();
					while(!enteredCorrectly)
					{
						System.out.println("Please enter Human/Human, Human/AI or AI/AI to start the respective game:");
						line = input.readLine();

						if(line.equals("Human/Human"))
						{
							playerOne = new C4HumanPlayer(RED, "Player 1");
							playerTwo = new C4HumanPlayer(YELLOW,"Player 2");
							enteredCorrectly = true;
						}
						else if(line.equals("Human/AI"))
						{
							playerOne = new C4HumanPlayer(RED,"Player 1");
							playerTwo = new C4RandomAIPlayer(YELLOW,"Player 2");
							enteredCorrectly = true;
						}
						else if(line.equals("AI/AI"))
						{
							playerOne = new C4RandomAIPlayer(RED,"Player 1");
							playerTwo = new C4RandomAIPlayer(YELLOW,"Player 2");
							enteredCorrectly = true;
						}
						else
						{
							System.err.println("Please enter again. Incorrect input");
						}
					}

					int lastPlayer = PLAYER_TWO;

					while(!grid.didLastPieceConnect4()&&!grid.isGridFull())
					{
						System.out.println(grid);			
						if(lastPlayer == PLAYER_ONE)
						{
							lastPlayer = PLAYER_TWO;
							playerTwo.decideWhereToDrop(grid);
						}
						else 
						{
							lastPlayer = PLAYER_ONE;
							playerOne.decideWhereToDrop(grid);
						}
					}

					System.out.println(grid);
					if(grid.didLastPieceConnect4())
					{
						if(lastPlayer == PLAYER_ONE)
						{
							System.out.println("First player won");
						}
						else
						{
							System.out.println("Second player won");
						}
					}
					else
					{
						System.out.println("The grid is full, it is a draw");
					}		
				}
			}

		}


	}


}
