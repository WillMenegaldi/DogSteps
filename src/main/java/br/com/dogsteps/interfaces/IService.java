package br.com.dogsteps.interfaces;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IService<T, K, DTO>
{
    public Response post(T t);
}
