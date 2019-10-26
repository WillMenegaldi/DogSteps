package br.com.dogsteps.models;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class Agenda implements Serializable{

	private ArrayList<Tour> horarios;
	private ArrayList<DayOfWeek> diasDisponivieis;
	private DogWalker dogWalker;

	public Agenda() {}
}
