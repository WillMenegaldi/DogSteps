package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.interfaces.IService;
import br.com.dogsteps.models.Pet;
import br.com.dogsteps.models.dto.PetDTO;
import br.com.dogsteps.repositories.PetRepository;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pets")
public class PetService implements IService<Pet, String, PetDTO> {

    private static IRepository<Pet, String, PetDTO> petRepository = new PetRepository();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pet> getAll() {
        return petRepository.getList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pet get(@PathParam("id") String id) {
        return petRepository.find(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Pet pet) {
        return petRepository.add(pet);
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Pet pet) {
        return petRepository.update(pet);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") String id) {
        return petRepository.remove(id);
    }

    @Override
    public List<Pet> getListByFilter(PetDTO petDTO) {
        return null;
    }
}
