package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.interfaces.IService;
import br.com.dogsteps.models.Tutor;
import br.com.dogsteps.repositories.TutorRepository;
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

@Path("/tutores")
public class TutorService implements IService<Tutor, String>
{
	private static IRepository<Tutor, String> tutorRepository = new TutorRepository();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Tutor> getAll() {
		return tutorRepository.getList();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Tutor get(@PathParam("id") String id) {
		return tutorRepository.find(id);
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response insert(Tutor Tutor) {
		return tutorRepository.add(Tutor);
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response update(Tutor Tutor) {
		return tutorRepository.update(Tutor);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response remove(@PathParam("id") String id) {
		return tutorRepository.remove(id);
	}
}
