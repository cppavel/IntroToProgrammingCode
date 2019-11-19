/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment: Yes, I did. All the constants' and variables' names give a good explanation of what they
        stand for. All of them are formatted correctly. 
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment: The indentation is done according to the coding standard.
 3. Did I implement the main line correctly with a loop which continues using the user says "no" ?
       Mark out of 10: 10
        Comment:  Yes, I did. The loop continues until the user says no. 
 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
       Mark out of 10: 10
        Comment:  Yes, I did. Output is the same as sample and the input is processed correctly.
 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment: Yes, I did the function is implemented in the exact same way as it is stated in the task and works correctly.
 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  Yes, I did the function is implemented in the exact same way as it is stated in the task and works correctly.
 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  Yes, I did the function is implemented in the exact same way as it is stated in the task and works correctly.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: I honestly assessed my work and self-assessment helped me to improve the code.
 Total Mark out of 100 (Add all the previous marks): 100
 */ 

import java.util.Scanner;

public class MortgageCalculator 
{
	public static final String QUESTION_MORTGAGE_AMOUNT = "Please enter the mortgage amount:";
	public static final String QUESTION_INTEREST_VALUE = "Please enter the annual interest rate (APR):";
	public static final String QUESTION_MONTH_PAYMENT  = "How much can you afford to pay per month?";
	public static final String QUESTION_USE_AGAIN = "Would you like to use the mortgage calculator again (yes/no)?";
	public static final int ERROR = -1;
	public static final int WILL_NEVER_PAY_IT_BACK = -2;
	public static final int MONTHS_IN_YEAR = 12;
	public static final int MORTGAGE_DURATION = 20;

	public static double realDoubleFromUser(String question)
	{
		System.out.println(question);

		Scanner input = new Scanner(System.in);

		boolean inputIncorrect = true;

		double returnValue = ERROR;

		while(inputIncorrect)
		{
			while(!input.hasNextDouble())
			{
				input.nextLine();
				System.out.println("Please enter the number again: ");
			}

			returnValue = input.nextDouble();				
			if(returnValue>0)
			{
				inputIncorrect = false;

			}
			else
			{
				input.nextLine();
				System.out.println("Number must be positive. Please enter again: ");
			}

		}

		return returnValue;

	}

	public static double calculateMonthlyRepayment(double mortgageAmount, double mortgageDuration, double annualInterestRate)
	{
		return mortgageAmount * ((annualInterestRate/MONTHS_IN_YEAR)/100)/
				(1 - Math.pow(1 + (annualInterestRate/MONTHS_IN_YEAR)/100,-mortgageDuration*MONTHS_IN_YEAR));
	}

	public static int calculateMonthsToRepayMortgage(double mortgageAmount, double repaidMonthly,double annualInterestRate)
	{

		int numberOfMonths = 0;

		double monthlyInterest = (annualInterestRate/MONTHS_IN_YEAR)/100;

		if(mortgageAmount*monthlyInterest>=repaidMonthly)
		{
			return WILL_NEVER_PAY_IT_BACK;
		}
		else
		{	
			while(mortgageAmount > 0)
			{
				mortgageAmount *= (1+monthlyInterest);
				mortgageAmount -=repaidMonthly;
				numberOfMonths++;
			}
		}

		return numberOfMonths;
	}

	public static void main(String[] args) 
	{
		System.out.println("Welcome to mortgage calculator");
		boolean userWantsToContinue = true;
		do
		{
			double mortgageAmount = realDoubleFromUser(QUESTION_MORTGAGE_AMOUNT);
			double annualInterestRate = realDoubleFromUser(QUESTION_INTEREST_VALUE);

			System.out.format("Assuming a "+ MORTGAGE_DURATION + " year term, the monthly repayments would be %.2f \n",
					calculateMonthlyRepayment(mortgageAmount, MORTGAGE_DURATION, annualInterestRate));

			double possibleToRepayMonthly = realDoubleFromUser(QUESTION_MONTH_PAYMENT);

			int numberOfMonths = calculateMonthsToRepayMortgage(mortgageAmount, possibleToRepayMonthly, annualInterestRate);

			if(numberOfMonths != WILL_NEVER_PAY_IT_BACK)
			{

				int numberOfYears = numberOfMonths/MONTHS_IN_YEAR;
				int numberOfMonthsNotFullYear = numberOfMonths - numberOfYears*MONTHS_IN_YEAR;

				System.out.format("If you pay %.2f per month your mortgage would be paid off in %d years and %d months.\n",
						possibleToRepayMonthly,numberOfYears,numberOfMonthsNotFullYear);
			}
			else
			{
				System.out.println("You will never pay it back");
			}

			System.out.println(QUESTION_USE_AGAIN);

			Scanner input = new Scanner(System.in);

			while(!input.hasNext("no")&&!input.hasNext("yes"))
			{
				input.nextLine();
				System.out.println("Incorrect input, enter again: ");		
			}

			String useAgain = input.next();

			if(useAgain.equals("no"))
			{
				userWantsToContinue = false;
			}

		}while(userWantsToContinue);


	}

}
