import java.io.InputStreamReader;
import java.io.BufferedReader;
public class C4HumanPlayer extends ConnectPlayer
{
	public C4HumanPlayer(int color, String name)
	{
		super(color,name);
	}
	
	@Override
	public void decideWhereToDrop(Connect4Grid2DArray grid) throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		boolean enteredCorrectly = false;
		
		while(!enteredCorrectly)
		{
			System.out.println(this.getPlayerName()+", Please enter a column, where to put your disc (from 0 to 6): ");
			String line = input.readLine();
			if(integerTryParse(line))
			{
				int column = Integer.parseInt(line);
				if(!grid.isColumnFull(column))
				{
				
					grid.dropPiece(this, column);
					enteredCorrectly = true;	
				}
				
			}
			
			
		}
	}
}
