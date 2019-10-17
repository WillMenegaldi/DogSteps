package br.com.dogsteps.service;

import java.util.ArrayList;
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

import br.com.dogsteps.Tes;

@Path("/dogwalker")
public class Service {

	// Produces = GET E DELETE, Consumes = PUT E POST

	List<Tes> lis = new ArrayList<Tes>();

	@GET
	@Path("/dogwalkers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tes> index() {
		lis.add(new Tes(1, "Jao", 18));
		lis.add(new Tes(2, "Jao", 18));
		lis.add(new Tes(3, "Jao", 18));
		lis.add(new Tes(4, "Jao", 18));
		return lis;
	}

	@GET
	@Path("/dogwalker/{id}")
	@Produces(MediaType.APPLICATION_JSON) // Retorna um tipo especifico, seja uma lista ou um apenas
	public Tes show(@PathParam("id") int id) {
		System.out.println(id);
		lis.add(new Tes(1, "Jao", 18));
		lis.add(new Tes(2, "Jao", 18));
		lis.add(new Tes(3, "Jao", 18));
		lis.add(new Tes(4, "Jao", 18));
		return lis.get(id);
	}

	@POST
	@Path("/dogwalkers")
	@Consumes(MediaType.APPLICATION_JSON) // rotarna um response
	public Response store(Tes tes) {
		Tes t = new Tes();
		t.setIdade(tes.getIdade());
		t.setNome(tes.getNome());
		System.out.println(t);
		lis.add(t);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("/dogwalker")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Tes tes) {
		
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
