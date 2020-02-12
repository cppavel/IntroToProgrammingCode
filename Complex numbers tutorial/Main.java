
public class Main 
{
	public static void main(String [] args)
	{
		Complex a = new Complex(1,2);
		Complex b = new Complex(1,3);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		Complex add = Complex.add(a, b);
		Complex mult = Complex.multiply(a, b);
		Complex div = Complex.divide(a, b);
		
		System.out.println(add.toString());
		System.out.println(mult.toString());
		System.out.println(div.toString());
	}

}
