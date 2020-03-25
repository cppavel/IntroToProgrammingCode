
public class Student extends Person
{
	private double gpa;
	
	public Student(double gpa,String firstName, String lastName, String address, int id)
	{
		super(firstName, lastName, address,id);
		this.gpa = gpa;
	}
	
	void setGpa(double gpa)
	{
		this.gpa = gpa;
	}
	
	double getGpa()
	{
		return gpa;
	}
	
	@Override
	public void display()
	{
		System.out.format("First name: %s, Last name: %s, Address: %s, Id: %d, GPA: %.2f %n", this.getFirstName(), this.getLastName(), this.getAddress(), id, gpa);
	}
}
