package br.com.dogsteps.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import br.com.dogsteps.interfaces.IFilterLogin;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.UserDto;
import br.com.dogsteps.utils.Login;

@Path("/login")
public class LoginService
{
    private static IFilterLogin userRepository = new Login();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public User logarUsuario(UserDto userDto)
    {
        return userRepository.filtrarUsuario(userDto);
    }
}