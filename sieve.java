import java.util.Scanner;

public class Sieve 
{

	public static final int NOT_INITIALIZED = -1;
	
	public static int[] createSequence(int n)
	{
		int [] sequence = new int[n-1];
		
		for(int i =2;i<=n;i++)
		{
			sequence[i-2] = i;
		}
		
		return sequence;
	}
	
	public static void crossOutHigherMultiples(int [] sequence, int n)
	{
		for(int i =0;i<sequence.length;i++)
		{
			if(sequence[i]>0&&sequence[i]%n == 0 && sequence[i]/n !=1)
			{
				sequence[i] = -sequence[i];
			}
		}
	}
	
	public static int[] sieve(int n)
	{
		
		int [] sequence = createSequence(n);
		
		int max = (int)Math.sqrt(sequence[sequence.length-1]) + 1 ;
		
		System.out.println(sequenceToString(sequence));
		
		for(int i =2; i<=max;i++)
		{
			if(sequence[i-2]>0)
			{
				crossOutHigherMultiples(sequence,i);
				System.out.println(sequenceToString(sequence));
			}
		}
		
		return sequence;
	}
	
	public static String sequenceToString(int[] sequence)
	{
		String result = "";
		for(int i =0;i<sequence.length;i++)
		{
			if(sequence[i]>0)
			{
				result+= sequence[i]+", ";
			}
			else
			{
				result+= "[" + (-sequence[i]) +"], ";
			}
		}
		
		result = result.substring(0, result.length()-2);
		result+=".";
		
		return result;
	}
	
	public static String nonCrossedOutSubseqToString(int[] sequence)
	{
		String result = "";
		for(int i =0;i<sequence.length;i++)
		{
			if(sequence[i]>0)
			{
				result+= sequence[i]+", ";
			}		
		}
		
		result = result.substring(0, result.length()-2);
		result+=".";
		
		return result;
	}
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
			
		int n = NOT_INITIALIZED ;
		
		boolean userEnteredCorrectly = false;
		
		while(!userEnteredCorrectly)
		{
			System.out.print("Please int >=2: ");
			if(!input.hasNextInt())
			{
				input.nextLine();
			}
			else
			{
				n = input.nextInt();
				if(n>=2)
				{
					userEnteredCorrectly = true;
				}
				
			}
		}
		 
		
		int[] sequence = sieve(n);			
		
		System.out.println(nonCrossedOutSubseqToString(sequence));
		
		input.close();

	}

}
