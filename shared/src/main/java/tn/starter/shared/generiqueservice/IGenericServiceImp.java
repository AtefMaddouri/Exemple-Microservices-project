package tn.starter.shared.generiqueservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


public class IGenericServiceImp<T,ID> implements IGenericService<T,ID> {

	@Autowired
	CrudRepository<T,ID> baseRepository;



	@Override
	public T add(T entity) {
		return baseRepository.save(entity);
	}

	@Override
	public T update(T entity) {
		return baseRepository.save(entity);
	}

	@Override
	public T retrieveById(ID id) {
		return baseRepository.findById(id).orElse(null);
	}


	@Override
	public Iterable<T> retrieveAll() {
		return baseRepository.findAll();
	}

	@Override
	public Boolean delete(ID id) {
		if (baseRepository.existsById(id)) {
			baseRepository.deleteById(id);
			return true;
		}
		else {return false;}
	}

}
