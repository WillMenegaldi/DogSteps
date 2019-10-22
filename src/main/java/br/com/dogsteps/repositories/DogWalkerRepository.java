package br.com.dogsteps.repositories;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.DogWalker;

public class DogWalkerRepository implements IRepository<DogWalker, String> {

	private static final String FILE_NAME = "database/dogwalker";
	private final Dao DOGWALKER_DAO = inicializarDao();

	public Dao inicializarDao() {
		try {
			return new Dao(FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<DogWalker> getList() {
		return DOGWALKER_DAO.getAll();
	}

	public DogWalker find(String id) {
		return (DogWalker) DOGWALKER_DAO.get(id);
	}

	public Response add(DogWalker dogWalker) {
		if (DOGWALKER_DAO.add(dogWalker))
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

	public Response update(DogWalker dogWalker) {
		if (DOGWALKER_DAO.update(dogWalker))
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

	public Response remove(String id) {
		if (DOGWALKER_DAO.remove(id))
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

}
