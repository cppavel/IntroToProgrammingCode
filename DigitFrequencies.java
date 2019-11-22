import java.util.Scanner;
public class DigitFrequencies 
{
	
	
	
	public static void countDigitFrequencies(int number, int[] frequencies)
	{
		if(frequencies!=null&&frequencies.length == 10)
		{
			while(number>0)
			{
				int currentDigit = number%10;
				frequencies[currentDigit]++;
				number = number / 10;
			}
		}
	}
	
	public static void printDigitFrequencies(int [] frequencies)
	{
		if(frequencies!=null&&frequencies.length == 10)
		{
			System.out.print("Digit frequencies: ");
			
			for(int index = 0;index<frequencies.length;index++)
			{
				if(frequencies[index]>0)
				{
					System.out.format("%d(%d) ",index, frequencies[index]);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		int[] frequencies = new int[10];
		
		for(int index = 0; index < 10; index++)
		{
			frequencies[index] = 0;
		}
		
		Scanner input  = new Scanner(System.in);
		
		boolean finish  = false;
		
		while(!finish)
		{
			System.out.print("Please enter the next number or exit, if you wish to finish ->");
			while(!input.hasNextInt()&&!input.hasNext("exit"))
			{
				System.out.println("Please enter the next number or exit, if you wish to finish ->");
				input.nextLine();
			}
			
			if(input.hasNextInt())
			{
			
				int currentNumber = input.nextInt();			
				countDigitFrequencies(currentNumber,frequencies);
				printDigitFrequencies(frequencies);
				input.nextLine();
			}
			else if(input.hasNext("exit"))
			{
				finish  =  true;
			}
		}
		
		input.close();
		

	}

}
