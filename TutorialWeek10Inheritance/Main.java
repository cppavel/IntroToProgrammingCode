
public class Main 
{

	public static void main(String[] args) 
	{
		Person pr = new Person("a","b","c",1);
		
		Person sd = new Student(5.0,"a","b","c",2);
		
		Person ep = new Employee("d","a","b","c",3);
		
		pr.display();
		sd.display();
		ep.display();

	}

}
