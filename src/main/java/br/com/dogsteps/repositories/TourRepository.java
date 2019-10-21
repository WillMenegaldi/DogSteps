package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.TourDAO;
import br.com.dogsteps.models.Tour;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class TourRepository {
	private static final String FILE_NAME = "database/tour.bin";
	private static final TourDAO TOUR_DAO = initTourDao();

	private static TourDAO initTourDao(){
		try {
			return new TourDAO(FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Tour> getList() {
		return TOUR_DAO.getAll();
	}
	public static Tour find(Integer id) {
		return TOUR_DAO.get(id);
	}
	public static Response add(Tour tour){
		return TOUR_DAO.add(tour) ?
				Response.status(Response.Status.OK).build()
				: Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response update(Tour tour){
		return TOUR_DAO.update(tour) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response remove(Integer id){
		return TOUR_DAO.remove(id) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
