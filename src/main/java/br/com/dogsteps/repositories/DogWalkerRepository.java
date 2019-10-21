package br.com.dogsteps.repositories;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.dogsteps.dao.DogWalkerIDAO;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.Tour;

public class DogWalkerRepository {

	private static final String FILE_NAME = "database/dogwalker.bin";
	private static final DogWalkerIDAO DOGWALKER_DAO = new DogWalkerIDAO(FILE_NAME);

	
	public static List<DogWalker> getList() {
		return DOGWALKER_DAO.getAll();
	}

	public static DogWalker find(Integer id) {
		return DOGWALKER_DAO.get(id);
	}
	public static Response add(DogWalker dogWalker){
		return DOGWALKER_DAO.add(dogWalker) ?
				Response.status(Response.Status.OK).build()
				: Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response update(DogWalker dogWalker){
		return DOGWALKER_DAO.update(dogWalker) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	public static Response remove(Integer id){
		return DOGWALKER_DAO.remove(id) ?
				Response.status(Response.Status.OK).build():
				Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
