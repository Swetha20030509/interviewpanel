package interviewpanel.manageinterviewer;
import java.util.*;
public class InterviewerView {

	Interviewermodel interviewermodel;
	public InterviewerView()
	{
		interviewermodel=new Interviewermodel(this);
	}
	public void addInterviewer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the interviewer name");
		String interviewerName=sc.nextLine();
		System.out.println("Enter the email id");
		String interviewerEmail=sc.nextLine();
		System.out.println("create the password");
		int interviewerPassword=sc.nextInt();
		interviewermodel.addDetail(interviewerName,interviewerEmail,interviewerPassword);
	}
	public String insertStatus()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the status update");
		String status=sc.nextLine();
		return status;
	}
	public void displayInterviewerMenu(String name)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Candidates status update");
		System.out.println("2.Exit");
		System.out.println("Enter your choice");
		String choice= sc.nextLine();
		switch(choice)
		{
			case "1":
				interviewermodel.statusUpdate(name,insertStatus());
				break;
		}
	}
	public void showMessage(String userDoesNotExits) {
		System.out.println(userDoesNotExits);
	}
}
