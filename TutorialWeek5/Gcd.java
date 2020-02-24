
public class Gcd 
{

	public static int gcd(int a, int b)
	{
		while(a!=0&&b!=0)
		{
			if(a>b)
			{
				a = a%b;
			}
			else
			{
				b = b%a;
			}
		}
		
		if(a==0)
		{
			return b;
		}
		else 
		{
			return a;
		}
	}
	public static void main(String[] args) 
	{
		System.out.println(gcd(54,24));
		System.out.println(gcd(2141414892,11241914));

	}

}
