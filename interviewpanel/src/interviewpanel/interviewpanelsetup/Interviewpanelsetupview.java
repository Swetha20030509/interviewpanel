package interviewpanel.interviewpanelsetup;
import java.util.*;
import interviewpanel.InterviewPanel;
import interviewpanel.managecandidates.CandidatesView;
import interviewpanel.manageinterviewer.InterviewerView;
import interviewpanel.model.Schedule;
import interviewpanel.*;
public class Interviewpanelsetupview {
	Interviewoanelsetupmodel interviewoanelsetupmodel;
	CandidatesView candidatesview;
	InterviewerView interviewerView;
	public Interviewpanelsetupview()
	{
		System.out.println("gcv uit");
		interviewoanelsetupmodel=new Interviewoanelsetupmodel(this);
		interviewerView=new InterviewerView();
		candidatesview=new CandidatesView();
	}

	public void init()
	{
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add interviewer");
			System.out.print("2.Add candiates");
			System.out.print("3.view Schedule details");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					interviewerView.addInterviewer();
					break;
				case 2:
					candidatesview.addCandiates();
					break;
				case 3:
					interviewoanelsetupmodel.scheduleInterview();
					break;
				case 4:
					InterviewPanel.getInstance().mainMenu();
					break;

			}
		}
	}
	public void ScheduleDisplay(ArrayList<Schedule> schedule) {
		System.out.printf("%-15s %-10s %-10s\n", "CandidateName", "Email", "InterviewerName");
		for(int i=0;i<schedule.size();i++)
		{
			System.out.printf("%-15s %-10s %-10s\n",schedule.get(i).getCandidates().getName(),schedule.get(i).getCandidates().getEmail(),schedule.get(i).getInterviewer().getName() );
		}
	}

	public void showMessage(String s) {
		System.out.println(s);
	}

	public void onsucessCandiates(String name) {
		Interviewoanelsetupmodel interviewoanelsetupmodel=new Interviewoanelsetupmodel();
		if(interviewoanelsetupmodel.isCandidates(name))
		{
			candidatesview.displayCandidatesMenu(name);
		}
		else if(interviewoanelsetupmodel.isInterviewer(name))
		{
			interviewerView.displayInterviewerMenu(name);
		}
	}
}
