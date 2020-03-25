
public class Employee extends Person
{
	private String jobTitle; 
	
	public Employee(String jobTitle,String firstName, String lastName, String address, int id)
	{
		super(firstName, lastName, address,id);
		this.jobTitle= jobTitle;
	}
	
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}
	
	public String getJobTitle()
	{
		return jobTitle;
	}
	
	@Override
	public void display()
	{
		System.out.format("First name: %s, Last name: %s, Address: %s, Id: %d, Job title: s %n", this.getFirstName(), this.getLastName(), this.getAddress(), id, jobTitle);
	}
}
