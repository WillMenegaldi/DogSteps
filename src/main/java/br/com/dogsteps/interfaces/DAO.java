package br.com.dogsteps.interfaces;

import java.util.List;

public interface DAO<T,K> {

	public T get(K k);

	public boolean add(T t);

	public boolean remove(K k);

	public boolean update(T t, K k);

	public List<T> getAll();
}
