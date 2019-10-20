package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.TourDAO;
import br.com.dogsteps.models.Tour;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class RepositoryTour {
	private static final String FILENAME = "database/tour.bin";
	private static final TourDAO tourDAO = initTourDao();

	private static TourDAO initTourDao(){
		try {
			return new TourDAO(FILENAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Tour> getList() {
		return tourDAO.getAll();
	}
	public static Tour find(Integer id) {
		return tourDAO.get(id);
	}
	public static Response add(Tour tour){
		return tourDAO.add(tour) ? Response.status(Response.Status.OK).build(): Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response update(Tour tour, Integer id){
		return tourDAO.update(tour, id) ? Response.status(Response.Status.OK).build(): Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response remove(Integer id){
		return tourDAO.remove(id) ? Response.status(Response.Status.OK).build(): Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
