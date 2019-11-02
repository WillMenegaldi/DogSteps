package br.com.dogsteps.models;
import br.com.dogsteps.enums.EDay;
import br.com.dogsteps.enums.ESchedule;
import java.io.Serializable;
import java.util.List;

public class Agenda implements Serializable{
	private ESchedule horario;
	private List<EDay> dias;

	public Agenda(ESchedule horario, List<EDay> dias) {
		this.horario = horario;
		this.dias = dias;
	}

	public ESchedule getHorario() {
		return horario;
	}
	public void setHorario(ESchedule horario) {
		this.horario = horario;
	}

	public List<EDay> getDias() {
		return dias;
	}
	public void setDias(List<EDay> dias) {
		this.dias = dias;
	}

	public Agenda() {}
}
