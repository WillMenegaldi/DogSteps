package br.com.dogsteps.interfaces;

import java.util.List;
import java.util.Optional;

public interface DAO<T,K> {

	public Optional<T> get(K k);

	public void add(T t);

	public T remove(K k);

	public boolean update(T t, K k);

	public List<T> getAll();
}
