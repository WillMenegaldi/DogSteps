package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IBaseRepository;
import br.com.dogsteps.interfaces.IBaseService;
import br.com.dogsteps.interfaces.IRepositoryFilter;
import br.com.dogsteps.interfaces.IServiceFilter;
import br.com.dogsteps.models.Avaliacao;
import br.com.dogsteps.models.dto.AvaliacaoDto;
import br.com.dogsteps.repositories.AvaliacaoRepository;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/avaliacoes")
public class AvaliacaoService implements IServiceFilter<Avaliacao, AvaliacaoDto>, IBaseService<Avaliacao> {
    private IBaseRepository<Avaliacao> avaliacaoDaoRepository = new AvaliacaoRepository();
    private IRepositoryFilter<Avaliacao, AvaliacaoDto> avaliacaoFilterRepository = new AvaliacaoRepository();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response post(Avaliacao avaliacao) {
        return avaliacaoDaoRepository.add(avaliacao);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Avaliacao> getAll() {
        return avaliacaoDaoRepository.getList();
    }

    @POST
    @Path("/filter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public List<Avaliacao> getListByFilter(AvaliacaoDto avaliacaoDto) {
        return avaliacaoFilterRepository.getListByFilter(avaliacaoDto);
    }
}
