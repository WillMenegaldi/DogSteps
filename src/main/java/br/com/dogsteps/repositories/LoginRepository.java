package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.Dao;
import br.com.dogsteps.interfaces.IRepository;
import br.com.dogsteps.models.User;
import br.com.dogsteps.models.dto.UserDto;

import javax.ws.rs.core.Response;
import java.util.List;

public class LoginRepository implements IRepository<User, String, UserDto>
{
    @Override
    public Dao inicializarDao() {
        return null;
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public User find(String s) {
        return null;
    }

    @Override
    public Response add(User user) {
        return null;
    }

    @Override
    public Response update(User user) {
        return null;
    }

    @Override
    public Response remove(String s) {
        return null;
    }

    @Override
    public List<User> getListByFilter(UserDto userDto) {
        return null;
    }
}
