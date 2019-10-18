package br.com.dogsteps.interfaces;
import java.util.List;
public interface DAO<T, K> {
    public List<T> getAll();
    public T get();
    public void add(T t);
    public void update(T t);
    public void remove(K k);
}
