
public class Main 
{

	public static void main(String[] args) 
	{
		Shape[] shapes = new Shape[2];
		
		shapes[0] = new Rectangle("red",5,2);
		shapes[1] = new Triangle("blue", 3, 5);
		
		System.out.println(shapes[0]);
		System.out.println(shapes[1]);
		System.out.println(shapes[0].getArea());
		System.out.println(shapes[1].getArea());
		

	}

}
