package br.com.dogsteps.services;

import br.com.dogsteps.interfaces.IEstatistica;
import br.com.dogsteps.repositories.EstatisticasRepository;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/estatisticas")
public class EstatisticasService implements IEstatistica<String, String> {
    private IEstatistica<String, String> estatisticasService = new EstatisticasRepository();

    @GET
    @Path("/passeios")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getPasseiosEstatistica() {
        return estatisticasService.getPasseiosEstatistica();
    }

    @GET
    @Path("/cadastros")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getTotalCadastroDogWalker() {
        return estatisticasService.getTotalCadastroDogWalker();
    }

    @GET
    @Path("/pets")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getMediaPetsPorTutor() {
        return estatisticasService.getMediaPetsPorTutor();
    }

    @GET
    @Path("/idades")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getMediaIdadePasseadores() {
        return estatisticasService.getMediaIdadePasseadores();
    }

    @GET
    @Path("/horarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getMediaHorarioPasseio() {
        return estatisticasService.getMediaHorarioPasseio();
    }
}
