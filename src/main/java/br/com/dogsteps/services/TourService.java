package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IService;
import br.com.dogsteps.models.Tour;
import br.com.dogsteps.repositories.TourRepository;
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

@Path("/tours")
public class TourService implements IService<Tour, Integer> {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Tour> getAll() {
        return TourRepository.getList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Tour get(@PathParam("id") Integer id) {
        return TourRepository.find(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response insert(Tour tour) {
        return TourRepository.add(tour);
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response update(Tour tour) {
        return TourRepository.update(tour);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response remove(@PathParam("id") Integer id) {
        return TourRepository.remove(id);
    }
}
