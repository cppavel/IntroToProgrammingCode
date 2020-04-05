
public class Connect4Grid2DArray implements Connect4Grid
{
	public static final int N_ROWS = 6;
	public static final int N_COLUMNS = 7;
	private static final int EMPTY = 0;
	private static final int RED = 1;
	private static final int YELLOW = 2;
	private static final int NOT_INITIALIZED = -1;
	private static final int NEIGHBOUR_CELLS_TO_WIN = 3;
	private int[][] grid;
	private int[] lastEmptyIndex;
	private int lastColumn;
	
	public Connect4Grid2DArray()
	{
		grid = new int[N_ROWS][N_COLUMNS];
		lastEmptyIndex = new int[N_COLUMNS];
		emptyGrid();
		
	
	}
	
	public void emptyGrid()
	{
		for(int i = 0 ;i < N_ROWS; i++)
		{
			for(int j = 0; j < N_COLUMNS;j++)
			{
				grid[i][j] = EMPTY;
			}
		}
		
		for(int i = 0; i< N_COLUMNS;i++)
		{
			lastEmptyIndex[i] = N_ROWS - 1;
		}
		
		lastColumn = NOT_INITIALIZED;
	}
	
	public String toString()
	{
		String gridString ="";
		
		for(int i = 0;i<N_ROWS;i++)
		{
			for(int j = 0;j<N_COLUMNS;j++)
			{
				switch(grid[i][j])
				{
				case EMPTY: gridString = gridString +"E ";break;
				case RED:  gridString = gridString +"R ";break;
				case YELLOW:  gridString = gridString +"Y ";break;
				default: break;
				}
			}
			gridString = gridString +"\n";
		}
		
		
		return "Grid:\n0 1 2 3 4 5 6\n" + gridString+"0 1 2 3 4 5 6\n" +"E - empty, R - red, Y - yellow\n";		
	}
	
	public boolean isValidColumn (int column)
	{
		return (column>=0&&column<=N_COLUMNS-1);
	}
	
	public boolean isColumnFull(int column)
	{
		
		if(isValidColumn(column))
		{
			return lastEmptyIndex[column]<0;
		}
		else
		{
			return true;
		}
				
	}
	
	public void dropPiece(ConnectPlayer player, int column)
	{
		if(!isColumnFull(column))
		{
			int color = player.getDiscColor();
			grid[lastEmptyIndex[column]][column] = color;
			lastEmptyIndex[column]--;
			lastColumn = column;
			
		}
	}
	
	public boolean didLastPieceConnect4()
	{
		if(lastColumn != NOT_INITIALIZED)
		{
			
			
			int lastRow = lastEmptyIndex[lastColumn] + 1;
			int color = grid[lastRow][lastColumn];
			boolean rightColumn = lastColumn + NEIGHBOUR_CELLS_TO_WIN <= N_COLUMNS -1;
			boolean leftColumn = lastColumn - NEIGHBOUR_CELLS_TO_WIN >=0;
			boolean topRow = lastRow - NEIGHBOUR_CELLS_TO_WIN >=0;
			boolean bottomRow = lastRow + NEIGHBOUR_CELLS_TO_WIN <= N_ROWS -1;
			
			
			//check top
			if(topRow)
			{
				if(color == grid[lastRow - 1][lastColumn]&&
						color == grid[lastRow - 2][lastColumn]&&
							color == grid[lastRow - 3][lastColumn])
				{
					return true;
				}
			}
			//check bottom
			if(bottomRow)
			{
				if(color == grid[lastRow + 1][lastColumn]&&
						color == grid[lastRow + 2][lastColumn]&&
							color == grid[lastRow + 3][lastColumn])
				{
					return true;
				}
			}
			//check left
			if(leftColumn)
			{
				if(color == grid[lastRow][lastColumn - 1]&&
						color == grid[lastRow][lastColumn - 2]&&
							color == grid[lastRow][lastColumn - 3])
				{
					return true;
				}
			}
			//check right
			if(rightColumn)
			{
				if(color == grid[lastRow][lastColumn + 1]&&
						color == grid[lastRow][lastColumn + 2]&&
							color == grid[lastRow][lastColumn + 3])
				{
					return true;
				}
			}
			//check top left
			if(leftColumn&&topRow)
			{
				if(color == grid[lastRow - 1][lastColumn - 1]&&
						color == grid[lastRow - 2][lastColumn - 2]&&
							color == grid[lastRow - 3][lastColumn - 3])
				{
					return true;
				}
			}
			//check top right
			if(rightColumn&&topRow)
			{
				if(color == grid[lastRow - 1][lastColumn + 1]&&
						color == grid[lastRow - 2][lastColumn + 2]&&
							color == grid[lastRow - 3][lastColumn + 3])
				{
					return true;
				}
			}
			//check bottom left
			if(leftColumn&&bottomRow)
			{
				if(color == grid[lastRow + 1][lastColumn - 1]&&
						color == grid[lastRow + 2][lastColumn - 2]&&
							color == grid[lastRow + 3][lastColumn - 3])
				{
					return true;
				}
			}
			//check bottom right
			if(rightColumn&&bottomRow)
			{
				if(color == grid[lastRow + 1][lastColumn + 1]&&
						color == grid[lastRow + 2][lastColumn + 2]&&
							color == grid[lastRow + 3][lastColumn + 3])
				{
					return true;
				}
			}
			
			return false;				
		}
		else
		{
			return false;
		}
	}
	
	public boolean isGridFull() 
	{
		for(int i = 0 ;i<N_COLUMNS;i++)
		{
			if(!isColumnFull(i))
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
}
