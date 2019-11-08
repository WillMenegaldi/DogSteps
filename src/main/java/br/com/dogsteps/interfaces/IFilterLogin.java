package br.com.dogsteps.interfaces;

import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.UserDto;

import java.util.List;

public interface IFilterLogin
{
    public User filtrarUsuario(UserDto userDto );
}
