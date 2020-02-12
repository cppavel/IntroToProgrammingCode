
public class Complex 
{
	public  double x;
	public  double y;
	
	public Complex()
	{
		x = y = 0;
	}
	
	public Complex(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Complex add(Complex a, Complex b)
	{
		return new Complex(a.x + b.x,a.y + b.y);
	}
	
	public static Complex multiply(Complex a, Complex b)
	{
		return new Complex(a.x*b.x-a.y*b.y,a.x*b.y+a.y*b.x);
	}
	
	public static Complex divide(Complex a, Complex b)
	{
		double denominator = b.x*b.x + b.y*b.y;
		
		return new Complex((a.x*b.x+a.y*b.y)/denominator, (a.y*b.x-a.x*b.y)/denominator);
	}
	
	public String toString()
	{
		return this.x + " + "+this.y+"i";
	}
}