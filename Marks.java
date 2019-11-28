import java.util.Scanner;
public class Marks 
{

	public static final double FIRST_HONOUR = 70.0;
	public static final int ERROR = -1;

	public static double determineBestMark(double [] marks)
	{
		double max = ERROR;
		if(marks!=null&&marks.length!=0)
		{
			max = marks[0];

			for(int i = 1; i < marks.length; i++)
			{
				if(marks[i]>max)
				{
					max = marks[i];
				}
			}		
		}

		return max;
	}	

	public static int countFirstClassHonours(double [] marks)
	{
		int counter = ERROR;
		if(marks!=null&&marks.length!=0)
		{
			counter = 0;
			for(int i = 0; i<marks.length; i++)
			{
				if(marks[i]>=FIRST_HONOUR)
				{
					counter++;
				}
			}
		}

		return counter;
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean finished = false;
		double [] marks = new double[1];
		while(!finished)
		{
			System.out.println("Please enter the next mark:");
			while(!input.hasNextDouble()&&!input.hasNext("exit"))
			{
				System.out.println("Please enter the next mark again. Incorrect input:");
				input.nextLine();
			}
			if(input.hasNextDouble())
			{
				double currentMark = input.nextDouble();
				input.nextLine();
				if(currentMark>=0&&currentMark<=100)
				{
					marks[marks.length-1] = currentMark;
					System.out.format("%d students achieved first honours. The highest mark is %f\n", countFirstClassHonours(marks),
							determineBestMark(marks));
					double[] newMarks = new double[marks.length+1];
					System.arraycopy(marks,0,newMarks,0,marks.length);
					marks = newMarks;	
				}
				else
				{
					System.out.println("Please enter a valid percentage!");
				}
			}
			else
			{
				input.nextLine();
				finished = true;
			}
		}

		input.close();

	}
}
