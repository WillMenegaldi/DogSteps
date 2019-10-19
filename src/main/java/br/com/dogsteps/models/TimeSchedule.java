package br.com.dogsteps.models;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class TimeSchedule {

	private ArrayList<Tour> schedules;

	private ArrayList<DayOfWeek> disponibleAt;

	private Dogwalker dogwalker;

	public TimeSchedule() {

	}

	public void addTour(Tour t){
		schedules.add(t);
	}

}
