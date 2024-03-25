package interviewpanel.managecandidates;

import interviewpanel.datalayer.Interviewpaneldatabase;
import interviewpanel.model.Candidates;
import interviewpanel.model.Credentials;

public class CandidatesModel {
	CandidatesView candidatesView;
	public CandidatesModel(CandidatesView candidatesView)
	{
		this.candidatesView=candidatesView;
	}
	public void addCandiadateDetail(String candidatedName, String candidatedEmail, int candidatedPassword,String skills) {
		Candidates newcandidates=new Candidates(candidatedName,candidatedEmail,skills);
		Credentials credentials=new Credentials(candidatedName,candidatedPassword);

		Interviewpaneldatabase.getInstance().addCredentials(credentials);
		Interviewpaneldatabase.getInstance().addCandidates(newcandidates);
	}

	public void myStatus(String name) {
		Candidates candidates=Interviewpaneldatabase.getInstance().getDetail(name);
		try{
			candidatesView.MyStatus(candidates);
		}
		catch(Exception e)
		{
			System.out.println(candidates);
		}

	}
}
