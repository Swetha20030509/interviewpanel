package interviewpanel.interviewpanelsetup;

import java.util.ArrayList;

import interviewpanel.datalayer.Interviewpaneldatabase;
import interviewpanel.model.Candidates;
import interviewpanel.model.Interviewer;
import interviewpanel.model.Schedule;

public class Interviewoanelsetupmodel {
	Interviewpanelsetupview interviewpanelsetupview;
	public Interviewoanelsetupmodel()
	{

	}
	Interviewoanelsetupmodel(Interviewpanelsetupview interviewpanelsetupview)
	{
		this.interviewpanelsetupview=interviewpanelsetupview;
	}
	public void scheduleInterview() {
		ArrayList<Interviewer> interviewers = Interviewpaneldatabase.getInstance().getInterviewers();
		ArrayList<Candidates> candidates = Interviewpaneldatabase.getInstance().getCandidates();
		for (int i = 0; i < interviewers.size(); i++) {

			for (int j = 0; j < candidates.size() && i < interviewers.size(); j++) {
				if (interviewers.get(i).getCount() == 2) {
					i++;
				}
				interviewers.get(i).setCount(interviewers.get(i).getCount() + 1);
				Schedule schedule = new Schedule(interviewers.get(i), candidates.get(j));
				Interviewpaneldatabase.getInstance().addSchedule(schedule);

				if (Interviewpaneldatabase.getInstance().getSchedule().size() > 0)
					interviewpanelsetupview.ScheduleDisplay(Interviewpaneldatabase.getInstance().getSchedule());
				else
					interviewpanelsetupview.showMessage("No schedule allocated!!!");
			}
		}
	}
	public void getSchedule()
	{
		interviewpanelsetupview.ScheduleDisplay( Interviewpaneldatabase.getInstance().getSchedule());
	}


	public boolean isCandidates(String name) {
		return Interviewpaneldatabase.getInstance().isCandiates(name);
	}
	public boolean isInterviewer(String name) {
		return Interviewpaneldatabase.getInstance().isInterviewer(name);
	}
}
