package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.Tutor;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class TutorRepository implements IRepository<Tutor, String>
{
    private static final String FILE_NAME = "database/tutor.bin";
    private final Dao TUTOR_DAO = inicializarDao();

    public Dao inicializarDao()
    {
        try
        {
            return new Dao(FILE_NAME);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tutor> getList() {
        return TUTOR_DAO.getAll();
    }
    @Override
    public Tutor find(String id) {
        return TUTOR_DAO.get(id);
    }
    @Override
    public Response add(Tutor tutor){
        return TUTOR_DAO.add(tutor) ?
            Response.status(Response.Status.OK).build()
            : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @Override
    public Response update(Tutor tutor){
        return TUTOR_DAO.update(tutor) ?
            Response.status(Response.Status.OK).build():
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @Override
    public Response remove(String id){
        return TUTOR_DAO.remove(id) ?
            Response.status(Response.Status.OK).build():
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
