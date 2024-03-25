package interviewpanel.login;

import java.util.Scanner;

import interviewpanel.interviewpanelsetup.Interviewpanelsetupview;

public class LoginSetupView {
	LoginSetupModel loginsetupmodel;
	Interviewpanelsetupview interviewpanelsetupview;
	boolean flag=false;
	public LoginSetupView()
	{
		loginsetupmodel=new LoginSetupModel(this);
		interviewpanelsetupview=new Interviewpanelsetupview();
	}

	public void init() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the user name");
		String name=sc.nextLine();
		System.out.println("Enter the password");
		int password=sc.nextInt();
		if(loginsetupmodel.valid(name,password)==false)
			showMessage("Invalid username and password");
	}

	public void showMessage(String loginSuccessfully) {
		System.out.println(loginSuccessfully);
	}

	public void onSucees() {
		interviewpanelsetupview.init();
	}
	public void onSuccessUser(String name)
	{
		interviewpanelsetupview.onsucessCandiates(name);
	}
}
