package interviewpanel;

import interviewpanel.login.LoginSetupView;

import java.util.Scanner;

public class InterviewPanel {
	private static InterviewPanel interviewPanel;
	private static LoginSetupView loginsetupview;
	public static InterviewPanel getInstance()
	{
		System.out.println("vwiuo");
		if(interviewPanel==null)
			interviewPanel=new InterviewPanel();
		return interviewPanel;
	}
	public void mainMenu()
	{
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.sign In");
			System.out.println("2.Exit");
			System.out.println("Enter your choice");
			String choice = sc.nextLine();
			switch (choice) {
				case "1":
					loginsetupview.init();
					break;
				case "2":
					System.out.println("*******Thank you ***********");
					break;
				default:
					System.out.println("choose your correct choice");
					break;

			}
		}
	}
	public static void main(String[] args) {
		//InterviewPanel.getInstance();
		loginsetupview=new LoginSetupView();
		loginsetupview.init();
	}

}
