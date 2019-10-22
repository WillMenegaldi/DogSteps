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

import br.com.dogsteps.interfaces.IService;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.repositories.DogWalkerRepository;

public class DogWalkerService implements IService<DogWalker, String>{	
	
	private static DogWalkerRepository dwRepository = new DogWalkerRepository();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DogWalker> getAll(){
		return dwRepository.getList();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DogWalker get(@PathParam("id") String id) {
		return dwRepository.find(id);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(DogWalker dogWalker) {		
		return dwRepository.add(dogWalker);
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(DogWalker d) {
		return dwRepository.update(d);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id")String id) {
		return dwRepository.remove(id);
	}
	
}
