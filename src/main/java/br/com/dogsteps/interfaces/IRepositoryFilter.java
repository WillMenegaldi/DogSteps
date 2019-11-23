package br.com.dogsteps.interfaces;

import br.com.dogsteps.dao.Dao;
import javax.ws.rs.core.Response;
import java.util.List;

public interface IRepositoryFilter<T, DTO>
{
    public List<T> getListByFilter(DTO dto);
}
