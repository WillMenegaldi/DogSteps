package br.com.dogsteps.services;

import br.com.dogsteps.models.Tour;
import br.com.dogsteps.repositories.RepositoryTour;
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
public class TourService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tour> index() {
        return RepositoryTour.getList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tour show(@PathParam("id") int id) {
        return RepositoryTour.find(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON) 
    public Response store(Tour tour) {
        return RepositoryTour.add(tour);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Tour tour,@PathParam("id") int id) {
        return RepositoryTour.update(tour, id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id) {
        return RepositoryTour.remove(id);
    }
}
