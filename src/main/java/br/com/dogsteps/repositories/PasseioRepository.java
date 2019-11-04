package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.excecoes.DataInvalidaException;
import br.com.dogsteps.excecoes.ValorNegativoException;
import br.com.dogsteps.interfaces.IDao;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.Passeio;
import br.com.dogsteps.models.dto.TourDTO;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PasseioRepository implements IRepository<Passeio, String, TourDTO> {
	private static final String FILE_NAME = "database/tour.bin";
	private final IDao<Passeio, String> TOUR_DAO = inicializarDao();

	public Dao inicializarDao(){
		try {
			return new Dao(FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Passeio> getList() {
		return TOUR_DAO.getAll();
	}

	@Override
	public Passeio find(String id) {
		return (Passeio) TOUR_DAO.get(id);
	}

	@Override
	public Response add(Passeio passeio){
		try {
			validarRequisicao(passeio);
			if(TOUR_DAO.add(passeio))
				return Response.status(Response.Status.OK).build();
			else
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

		}catch (NullPointerException | ValorNegativoException |
				DataInvalidaException e){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@Override
	public Response update(Passeio passeio){
		try {
			validarRequisicao(passeio);
			return TOUR_DAO.update(passeio) ?
					Response.status(Response.Status.OK).build() :
					Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}catch (NullPointerException | ValorNegativoException |
				DataInvalidaException e){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@Override
	public Response remove(String id){
		if(! id.isEmpty()){
			return TOUR_DAO.remove(id) ?
					Response.status(Response.Status.OK).build():
					Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}else
			return Response.status(Response.Status.BAD_REQUEST).build();

	}

	@Override
	public List<Passeio> getListByFilter(TourDTO tourDTO) {
		return null;
	}

	private void validarRequisicao(Passeio passeio)
			throws NullPointerException, DataInvalidaException,
			ValorNegativoException {
		if(passeio != null){}
		else{
			throw new NullPointerException();
		}

		if(passeio.getData().isAfter(LocalDate.now())){}
		else{
			throw new DataInvalidaException();
		}

		if(passeio.getDuracao() > 0){}
		else{
			throw new ValorNegativoException();
		}
	}
}
