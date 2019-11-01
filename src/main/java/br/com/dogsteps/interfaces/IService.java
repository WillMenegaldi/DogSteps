package br.com.dogsteps.interfaces;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IService<T, K, DTO> {
    public List<T> getAll();
    public T get(K k);
    public Response insert(T t);
    public Response update(T t);
    public Response remove(K k);
    public List<T> getListByFilter(DTO dto);
}
