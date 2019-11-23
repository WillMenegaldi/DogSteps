package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IBaseRepository;
import br.com.dogsteps.interfaces.IBaseService;
import br.com.dogsteps.interfaces.IServiceFilter;
import br.com.dogsteps.models.Avaliacao;
import br.com.dogsteps.repositories.AvaliacaoRepository;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/avaliacoes")
public class AvaliacaoBaseService implements IServiceFilter<Avaliacao, String>, IBaseService<Avaliacao> {
    private IBaseRepository avaliacaoRepository = new AvaliacaoRepository();

    @POST
    @Path("/filter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public List<Avaliacao> getListByFilter(String s) {
        return avaliacaoRepository.getList();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response post(Avaliacao avaliacao) {
        return avaliacaoRepository.add(avaliacao);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Avaliacao> getAll() {
        return avaliacaoRepository.getList();
    }
}
