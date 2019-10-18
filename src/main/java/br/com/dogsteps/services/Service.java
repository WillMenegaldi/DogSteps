package br.com.dogsteps.services;

import java.util.List;

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
import br.com.dogsteps.repositories.RepositoryPet;

@Path("/dogwalker")
public class Service {

	RepositoryPet rp = new RepositoryPet();
	@GET
	@Path("/dogwalkers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pet> index() {
		return rp.getList();
	}

	@GET
	@Path("/dogwalker/{id}")
	@Produces(MediaType.APPLICATION_JSON) // Retorna um tipo especifico, seja uma lista ou um apenas
	public Pet show(@PathParam("id") int id) {
		System.out.println(id);
		return rp.getTes(id);
	}

	@POST
	@Path("/dogwalkers")
	@Consumes(MediaType.APPLICATION_JSON) // rotarna um response
	public Response store(Pet tes) {
		Pet t = tes;
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("/dogwalker")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Pet tes) {
		Pet t = tes;
		//Fazer atualização
		
		return Response.status(Status.CREATED).build();
	}

	@DELETE
	@Path("/dogwalkers/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id") int id) {
		
		// Fazer remoção
				
		return Response.status(Status.CREATED).build();
	}

}
