package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.interfaces.IDao;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.Pet;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class PetRepository implements IRepository<Pet, String> {

    private static final String DIRETORIO = "database/pets.bin";
    private final IDao<Pet, String> PET_DAO = inicializarDao();

    @Override
    public Dao inicializarDao() {
        try{
            return new Dao(DIRETORIO);
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List getList() {
        return PET_DAO.getAll();
    }

    @Override
    public Pet find(String id) {
        return (Pet) PET_DAO.get(id);
    }

    @Override
    public Response add(Pet pet) {
        if(PET_DAO.add(pet))
            return Response.status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public Response update(Pet pet) {
        if(PET_DAO.update(pet))
            return Response.status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public Response remove(String id) {
        if(PET_DAO.remove(id))
            return Response.status(Response.Status.OK).build();
        else
            return Response.status((Response.Status.INTERNAL_SERVER_ERROR)).build();
    }
}
