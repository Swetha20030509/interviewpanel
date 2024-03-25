package interviewpanel.login;

import interviewpanel.datalayer.Interviewpaneldatabase;

public class LoginSetupModel {
	LoginSetupView loginsetupview;
	LoginSetupModel(LoginSetupView loginsetupview)
	{
		this.loginsetupview=loginsetupview;
	}
	public boolean valid(String name, int password) {
		if(name.equals("swetha")&&password==123)
		{
			loginsetupview.showMessage("login successfully");
			loginsetupview.onSucees();
			return true;
		}
		else if(Interviewpaneldatabase.getInstance().loginProcess(name,password))
		{
			loginsetupview.onSuccessUser(name);
			return true;
		}
		return false;
	}

}
