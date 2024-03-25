package interviewpanel.datalayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import interviewpanel.model.Candidates;
import interviewpanel.model.Credentials;
import interviewpanel.model.Interviewer;
import interviewpanel.model.Schedule;

public class Interviewpaneldatabase {
	static Interviewpaneldatabase interviewpaneldatabase;
	ArrayList<Interviewer>allInterviewer=new ArrayList<>();
	ArrayList<Candidates> allCandidates=new ArrayList<Candidates>();
	ArrayList<Schedule>allSchedule=new ArrayList<>();
	ArrayList<Credentials>allCredentials=new ArrayList<>();
	ObjectMapper mapper=new ObjectMapper();
	public static Interviewpaneldatabase getInstance()
	{
		if(interviewpaneldatabase==null)
		{
			interviewpaneldatabase=new Interviewpaneldatabase();
		}
		return interviewpaneldatabase;
	}
	public void addInterviewer(Interviewer newinterviewer) {
		allInterviewer.add(newinterviewer);
		File file=new File("Interviewer.json");
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file,allInterviewer);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


    }
	public void addCandidates(Candidates newcandidates) {
		allCandidates.add(newcandidates);
		File file=new File("candidates.json");
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file,allCandidates);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
	public ArrayList<Interviewer> getInterviewers()
	{
		File file=new File("interviewer.json");
		if(file.length()==0)
		{
			return new ArrayList<>();
		}
		if(!file.exists())
		{
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);
		ArrayList<Interviewer> allinterviewer=new ArrayList<>();
		try {

			allinterviewer=mapper1.readValue(file, new TypeReference<ArrayList<Interviewer>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}

		return allinterviewer;
	}
	public ArrayList<Candidates> getCandidates()
	{
		File file=new File("candidates.json");
		if(file.length()==0)
		{
			return new ArrayList<>();
		}
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);
		ArrayList<Candidates> allCandidates;
		try {

			allCandidates=mapper1.readValue(file, new TypeReference<ArrayList<Candidates>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
		return allCandidates;
	}
	public  void addSchedule(Schedule schedule) {
		allSchedule.add(schedule);
		File file=new File("Schedule.json");
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file,allSchedule);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Schedule> getSchedule()
	{
		File file=new File("schedule.json");
		if(file.length()==0)
		{
			return new ArrayList<>();
		}
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);
		ArrayList<Schedule> allschedule;
		try {

			allschedule=mapper1.readValue(file, new TypeReference<ArrayList<Schedule>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
		return allschedule;
	}

	public boolean loginProcess(String name, int password) {
		File file=new File("Credentials.json");
		if(file.length()==0)
		{
			return false;
		}
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);
		ArrayList<Credentials> allCredentials;
		try {

			allCredentials=mapper1.readValue(file, new TypeReference<ArrayList<Credentials>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
		for(int i=0;i<allCredentials.size();i++)
		{
			if(allCredentials.get(i).getUserName().equals(name)&&allCredentials.get(i).getPassword()==password)
			{
				return true;
			}
		}
		return false;
	}

	public void addCredentials(Credentials credentials) {
		allCredentials.add(credentials);
		File file=new File("Credentials.json");
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file,allCredentials);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isCandiates(String name) {
		File file=new File("candidates.json");
		ArrayList<Candidates> allCandidates;
		if(file.length()==0)
		{
			return false;
		}
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);

		try {

			allCandidates=mapper1.readValue(file, new TypeReference<ArrayList<Candidates>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}

		for(int i=0;i<allCandidates.size();i++)
		{
			if(allCandidates.get(i).getName().equals(name))
			{
				return true;
			}
		}
		return false;
	}
	public boolean isInterviewer(String name) {
		File file=new File("interviewer.json");
		ArrayList<Interviewer> allinterviewer;
		if(file.length()==0)
		{
			return false;
		}
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			allinterviewer=mapper1.readValue(file, new TypeReference<ArrayList<Interviewer>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
		for(int i=0;i<allinterviewer.size();i++)
		{
			if(allinterviewer.get(i).getName().equals(name))
			{
				return true;
			}
		}
		return false;
	}

	public  Candidates getCandidate(String name) {
		File file=new File("schedule.json");
		ArrayList<Schedule> allschedule;
		if(file.length()==0)
		{
			return null;
		}
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			allschedule=mapper1.readValue(file, new TypeReference<ArrayList<Schedule>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
		for(int i=0;i<allschedule.size();i++) {
			if (allschedule.get(i).getCandidates().getName().equals(name)) {
				return allschedule.get(i).getCandidates();
			}
		}
		return null;
	}

	public Candidates getDetail(String name) {

		File file=new File("candidates.json");
		ArrayList<Candidates> allCandiates;
		if(file.length()==0)
		{
			return null;
		}
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		ObjectMapper mapper1=new ObjectMapper();
		mapper1.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			allCandiates=mapper1.readValue(file, new TypeReference<ArrayList<Candidates>>() {});
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
		for(int i=0;i<allCandiates.size();i++)
		{
			if(allCandiates.get(i).getName().equals(name))
			{
				return allCandiates.get(i);
			}
		}
		return null;
	}
}
