package br.com.dogsteps.services;

import javax.swing.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.dogsteps.models.Pet;
import br.com.dogsteps.repositories.PetRepository;

import java.util.List;

@Path("/pets")
public class PetService {

    PetRepository rpPet = new PetRepository();
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pet> index(){return rpPet.getList();}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pet searchPet(int id){return rpPet.getPet(id);}

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response store(Pet p){
        rpPet.savePet(p);
        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Pet p){
        if(rpPet.update(p))
            return Response.status(Status.ACCEPTED).build();
        else
            return Response.status(Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response remove(Pet p){
        if(rpPet.removePet(p))
            return Response.status(Status.ACCEPTED).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }

}
