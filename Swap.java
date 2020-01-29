
public class Swap 
{
	int a;
	int b;
	
	public Swap(int a ,int b)
	{
		this.a = a;
		this.b =b;
	}
	
	public void swap()
	{
		a=a-b;
		b=a+b;
		a=b-a;
	}
	
	public void print()
	{
		System.out.format("a =%d, b = %d\n",a,b);
	}
	public static void main(String[] args) 
	{
		Swap test = new Swap(2,3);
		test.print();
		test.swap();
		test.print();
		
	}
}