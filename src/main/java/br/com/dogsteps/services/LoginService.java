package br.com.dogsteps.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.interfaces.IRepositoryDao;
import br.com.dogsteps.interfaces.IServiceLogin;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.Tutor;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.DogWalkerDTO;
import br.com.dogsteps.models.dto.TutorDTO;
import br.com.dogsteps.models.dto.UserDto;
import br.com.dogsteps.repositories.DogWalkerRepository;
import br.com.dogsteps.repositories.TutorRepository;

import java.util.List;

@Path("/login")
public class LoginService {

    private static IRepositoryDao<DogWalker, String, DogWalkerDTO> dogWalkerRepository = new DogWalkerRepository();
    private static IRepository<Tutor, String, TutorDTO> tutorRepository = new TutorRepository();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<DogWalker> getListByFilter(DogWalkerDTO dogWalkerDTO)
    {
        return dogWalkerRepository.getListByFilter(dogWalkerDTO);
    }

}