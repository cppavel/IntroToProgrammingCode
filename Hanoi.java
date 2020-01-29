
public class Hanoi {

	// n - number of disks, pos - current position, free - number of the free position, move - position to move to
	
	static void Hanoi(int n,int pos, int free, int move)
	{
		if(n!=0)
		{
			Hanoi(n-1,pos,move, free);
			System.out.format("Disk number %d was moved to position %d from position %d\n",n,move,pos);
			Hanoi(n-1,free,pos,move);
		}	
	}
	
	public static void main(String[] args) 
	{
		Hanoi(2,1,2,3);
	}

}
