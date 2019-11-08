package br.com.dogsteps.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.interfaces.IServiceLogin;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.DogWalkerDTO;
import br.com.dogsteps.models.DogWalker;
import br.com.dogsteps.models.dto.UserDto;
import br.com.dogsteps.repositories.DogWalkerRepository;
import br.com.dogsteps.repositories.LoginRepository;

import java.util.List;

@Path("/login")
public class LoginService implements IServiceLogin<User, String, UserDto> {

    private static IRepository<User, String, UserDto> loginRepository = new LoginRepository();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(User user)
    {
        return loginRepository.add(user);
    }
}