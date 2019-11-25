package br.com.dogsteps.interfaces;

import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.UserDto;

public interface IFilterLogin<T, Dto>
{
    public T filtrarUsuario(Dto dto) throws Exception;
}
