package br.com.dogsteps.repositories;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.excecoes.AgendaNullException;
import br.com.dogsteps.excecoes.MenorIdadeException;
import br.com.dogsteps.excecoes.StringVaziaException;
import br.com.dogsteps.excecoes.ValorNegativoException;
import br.com.dogsteps.interfaces.IDao;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.DogWalker;
import org.jetbrains.annotations.NotNull;

public class DogWalkerRepository implements IRepository<DogWalker, String> {

	private static final String FILE_NAME = "database/dogwalker.bin";
	private final IDao<DogWalker, String> DOGWALKER_DAO = inicializarDao();

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
		try {
			if (DOGWALKER_DAO.add(dogWalker))
				return Response.status(Status.OK).build();
			else
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}catch (ValorNegativoException | StringVaziaException | MenorIdadeException |
				AgendaNullException e){
			return Response.status(Status.BAD_REQUEST).build();
		}

	}

	public Response update(DogWalker dogWalker) {
		try {
			validarRequisicao(dogWalker);
			if (DOGWALKER_DAO.update(dogWalker))
				return Response.status(Status.OK).build();
			else
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}catch (ValorNegativoException | StringVaziaException
				| MenorIdadeException | AgendaNullException e ){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	public Response remove(String id) {
		if (DOGWALKER_DAO.remove(id))
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}

	public void validarRequisicao(DogWalker dogWalker)
			throws ValorNegativoException, StringVaziaException,MenorIdadeException,AgendaNullException{

		if(dogWalker.getIdade() > 0){}
		else{
			throw new ValorNegativoException();
		}
		if(dogWalker.getIdade() > 18){}
		else{
			throw new MenorIdadeException();
		}

		if( ! (dogWalker.getCpf().isEmpty() || dogWalker.getNome().isEmpty()
				|| dogWalker.getSenha().isEmpty() 	|| dogWalker.getEmail().isEmpty() )){}
		else{
			throw new StringVaziaException();
		}

		if (dogWalker.getAgenda() != null){}
		else{
			throw new AgendaNullException();
		}
	}

}
