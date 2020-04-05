import java.util.ArrayList;
import java.util.Random;
public class C4RandomAIPlayer extends ConnectPlayer
{
	public  C4RandomAIPlayer (int color, String name)
	{
		super(color, name);
	}
	
	public void decideWhereToDrop(Connect4Grid2DArray grid) 
	{
		ArrayList<Integer> possibleColumns = new ArrayList<Integer>();
		for(int i = 0; i < Connect4Grid2DArray.N_COLUMNS;i++)
		{
			if(!grid.isColumnFull(i))
			{
				possibleColumns.add(i);
			}
		}
		
		Random rnd = new Random();
		
		int column = possibleColumns.get(Math.abs(rnd.nextInt()%possibleColumns.size()));
		
		grid.dropPiece(this, column);
		
		System.out.println(getPlayerName()+ " (AI) dropped at position " + column);
	}
}
