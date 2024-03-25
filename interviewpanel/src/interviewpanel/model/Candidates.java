package interviewpanel.model;

public class Candidates {
	String name;
	String email;

	String skills;
	String status;
	public Candidates(String candidatedName, String candidatedEmail, String skills2) {
		this.name=candidatedName;
		this.email=candidatedEmail;

		this.skills=skills2;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}

	public String getStatus() {
		return status;
	}
}
