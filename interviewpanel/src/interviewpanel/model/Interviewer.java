package interviewpanel.model;

public class Interviewer {
	String name;
	String email;
	int password;
	int count=0;
	
	public Interviewer(String name,String email)
	{
		this.name=name;
		this.email=email;
		this.password=password;
	}
	public String getName()
	{
		return name;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count=count;
	}
}
