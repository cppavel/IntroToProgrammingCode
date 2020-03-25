
public class Person 
{
	private String firstName;
	private String lastName;
	private String address;
	
	protected int id;
	
	public Person()
	{
		firstName = lastName = address = "Not Specified";
		id = -1;
	}
	
	public Person(String firstName, String lastName, String address, int id)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.id = id;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void display()
	{
		System.out.format("First name: %s, Last name: %s, Address: %s, Id: %d %n", firstName, lastName, address, id);
	}
	
	
}
