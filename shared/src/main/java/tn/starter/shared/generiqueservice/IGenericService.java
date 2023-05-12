package tn.starter.shared.generiqueservice;

import java.util.List;

public interface IGenericService<T,ID> {

	T add(T entity);
	T update(T entity);
	T retrieveById(ID id);
	Iterable<T> retrieveAll();
	Boolean delete(ID id);
	
}
