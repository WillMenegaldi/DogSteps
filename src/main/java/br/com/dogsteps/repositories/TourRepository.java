package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.dao.TourDAO;
import br.com.dogsteps.models.Tour;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class TourRepository {
	private static final String FILE_NAME = "database/tour.bin";
	private static final Dao TUTOR_DAO = initTourDao();

	private static Dao initTourDao(){
		try {
			return new Dao(FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Tutor> getList() {
		return TUTOR_DAO.getAll();
	}
	public static Tutor find(Integer id) {
		return TUTOR_DAO.get(id);
	}
	public static Response add(Tutor tutor){
		return TUTOR_DAO.add(tutor) ?
				Response.status(Response.Status.OK).build()
				: Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response update(Tutor tutor){
		return TUTOR_DAO.update(tutor) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response remove(Integer id){
		return TUTOR_DAO.remove(id) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
