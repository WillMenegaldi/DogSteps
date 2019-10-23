package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.interfaces.IService;
import br.com.dogsteps.models.Pet;
import br.com.dogsteps.repositories.PetRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pets")
public class PetService implements IService<Pet, String> {

    private static IRepository<Pet, String> petRepository = new PetRepository();

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
}
