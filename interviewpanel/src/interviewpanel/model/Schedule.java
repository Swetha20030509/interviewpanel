package interviewpanel.model;

public class Schedule {
	Candidates candidates;
	Interviewer interviewer;
	String Time;
	String Date;
	public Schedule(Interviewer interviewer, Candidates candidates) {
		this.candidates=candidates;
		this.interviewer=interviewer;
	}
	public Candidates getCandidates()
	{
		return candidates;
	}
	public Interviewer getInterviewer()
	{
		return interviewer;
	}
}
