package br.com.dogsteps.interfaces;

import br.com.dogsteps.dao.Dao;
import javax.ws.rs.core.Response;
import java.util.List;

public interface IRepository<T, K>{
    static Dao inicializarDao();
    public List<T> getList();
    public T find(K k);
    public Response add(T t);
    public Response update(T t);
    public Response remove(K k);
}
