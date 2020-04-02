
public class Rectangle extends Shape
{
	private int length;
	private int width;
	
	public Rectangle(String color, int length, int width)
	{
		super(color);
		this.length = length;
		this.width  = width;
	}
	
	@Override
	public double getArea()
	{
		return length*width;
	}
	
	@Override
	public String toString()
	{
		return String.format("color = %s, length = %d, width = %d", this.getColor(), length, width);
	}
}
