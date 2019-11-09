package br.com.dogsteps.utils;

import br.com.dogsteps.interfaces.IFilterLogin;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.UserDto;

public class Login implements IFilterLogin
{
    @Override
    public User filtrarUsuario(UserDto userDto) {
        return null;
    }
}
