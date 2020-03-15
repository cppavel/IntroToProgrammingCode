
public class NQueen 
{
	boolean[][] board;
	int size;
	boolean solutionFound = false;

	public NQueen(int N)
	{
		board = new boolean[N][N];
		size = N;

		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j<size;j++)
			{
				board[i][j] = false;
			}
		}
	}

	public void solve()
	{
		if(size==1)
		{
			board[0][0] = true;
		}
		else
		{
			for(int k = 0; k < size; k++)
			{
				if(!solutionFound)
				{	
					this.solve(this.size, 0, k);
				}
			}
		}

	}

	private void solve(int numberOfQueensLeft, int i, int j)
	{		
		if(numberOfQueensLeft == 0)
		{
			solutionFound = true;
			return;
		}
		board[i][j] = true;
		if(checkIfValid(i,j))
		{
			for(int k = 0;k<size;k++)
			{
				if(k!=j)
				{
					solve(numberOfQueensLeft-1, i+1,k);
					if(solutionFound)
					{
						break;
					}
				}
			}

		}
		if(!solutionFound)
		{
			board[i][j] = false;
		}

	}


	public boolean checkIfValid(int x, int y)
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j<size;j++)
			{
				if(board[i][j]&& (i!=x || j !=y))
				{
					int diffX = i - x;
					int diffY = j - y;

					diffX = Math.abs(diffX);
					diffY = Math.abs(diffY);

					if(diffX==diffY)
					{
						return false;
					}
					else if(diffX==0||diffY==0)
					{
						return false;
					}
				}
			}
		}

		return true;
	}

	public void print()
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(board[i][j])
				{
					System.out.print(1);
				}
				else
				{
					System.out.print(0);
				}
			}

			System.out.println();
		}
	}
}
