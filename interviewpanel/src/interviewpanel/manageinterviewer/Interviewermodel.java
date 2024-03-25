package interviewpanel.manageinterviewer;

import interviewpanel.datalayer.Interviewpaneldatabase;
import interviewpanel.model.Candidates;
import interviewpanel.model.Credentials;
import interviewpanel.model.Interviewer;
import interviewpanel.model.Schedule;

public class Interviewermodel {
	InterviewerView interviewerView;
	public Interviewermodel()
	{

	}
	public Interviewermodel(InterviewerView interviewerView2) {

		this.interviewerView=interviewerView2;
	}
	
	public void addDetail(String interviewerName, String interviewerEmail, int interviewerPassword) {
		Interviewer newinterviewer=new Interviewer(interviewerName,interviewerEmail);
		Credentials credentials=new Credentials(interviewerName,interviewerPassword);
		Interviewpaneldatabase.getInstance().addInterviewer(newinterviewer);
		Interviewpaneldatabase.getInstance().addCredentials(credentials);
	}
	public void statusUpdate(String name, String s) {
		Candidates candidates=Interviewpaneldatabase.getInstance().getCandidate(name);
		if(candidates!=null)
		candidates.setStatus(s);
		else
			interviewerView.showMessage("user does not exits");
	}
}
