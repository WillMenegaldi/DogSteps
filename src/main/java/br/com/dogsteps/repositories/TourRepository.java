 package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.Tour;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class TourRepository implements IRepository<Tour, String> {
	private static final String FILE_NAME = "database/tour.bin";
	private final Dao TOUR_DAO = inicializarDao();

	public Dao inicializarDao(){
		try {
			return new Dao(FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tour> getList() {
		return TOUR_DAO.getAll();
	}
	@Override
	public Tour find(String id) {
		return (Tour) TOUR_DAO.get(id);
	}
	@Override
	public Response add(Tour tour){
		return TOUR_DAO.add(tour) ?
				Response.status(Response.Status.OK).build()
				: Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	@Override
	public Response update(Tour tour){
		return TOUR_DAO.update(tour) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	@Override
	public Response remove(String id){
		return TOUR_DAO.remove(id) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
}
