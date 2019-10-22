package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IRepository;
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
public class TourService implements IService<Tour, String> {
    private static IRepository<Tour, String> tourRepository = new TourRepository();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Tour> getAll() {
        return tourRepository.getList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Tour get(@PathParam("id") String id) {
        return tourRepository.find(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response insert(Tour tour) {
        return tourRepository.add(tour);
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response update(Tour tour) {
        return tourRepository.update(tour);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response remove(@PathParam("id") String id) {
        return tourRepository.remove(id);
    }
}
