package br.com.dogsteps.interfaces;

import br.com.dogsteps.dao.Dao;
import javax.ws.rs.core.Response;
import java.util.List;

public interface IRepository<T, K, DTO>
{
    public List<T> getListByFilter(DTO dto);
}
