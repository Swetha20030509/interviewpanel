package interviewpanel.managecandidates;

import interviewpanel.model.Candidates;

import java.util.Scanner;

public class CandidatesView {
	CandidatesModel candidatesModel;
	public CandidatesView()
	{
		candidatesModel=new CandidatesModel(this);
	}

	public  void MyStatus(Candidates candidates) {
		System.out.printf("%-15s %-10s %-10s\n","name","EmailId","Status");
		System.out.printf("%-15s %-10s %-10s\n",candidates.getName(),candidates.getEmail(),candidates.getStatus());
	}

	public void addCandiates() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the candidated name");
		String candidatedName=sc.nextLine();
		System.out.println("Enter the candidated email id");
		String candidatedEmail=sc.nextLine();
		System.out.println("create the candidated password");
		int candidatedPassword=sc.nextInt();
		System.out.println("Enter the skills");
		String skill=sc.nextLine();
		candidatesModel.addCandiadateDetail(candidatedName,candidatedEmail,candidatedPassword,skill);
	}

	public void displayCandidatesMenu(String name) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.view profile");
		System.out.println("2.Exit");
		System.out.println("Enter your choice");
		String choice=sc.nextLine();
		switch(choice)
		{
			case "1":
				candidatesModel.myStatus(name);
				break;
		}
	}
}
