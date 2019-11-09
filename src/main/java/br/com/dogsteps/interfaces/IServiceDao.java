package br.com.dogsteps.interfaces;

import br.com.dogsteps.models.DogWalker;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IServiceDao<T, K, DTO> extends IService<T, K, DTO>
{
    public List<T> getAll();
    public T get(K k);
    public Response update(T t);
    public Response remove(K k);
    public List<T> getListByFilter(DTO dto);
}