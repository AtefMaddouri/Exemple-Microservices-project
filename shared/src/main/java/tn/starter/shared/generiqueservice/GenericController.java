package tn.starter.shared.generiqueservice;

import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class GenericController<DTO, T,ID> {
	@Autowired
	IGenericService<T,ID> genericService;

	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public DTO add(@RequestBody DTO dto) {

		T entity = (T) new Object();
		BeanUtils.copyProperties(dto,entity);
		genericService.add(entity);
		BeanUtils.copyProperties(entity,dto);
		return dto;

	}

	@PutMapping
	public DTO update(@RequestBody DTO dto) {
		Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		T entity = modelMapper.map(dto , entityClass);
		BeanUtils.copyProperties(dto,entity);

		genericService.update(entity);
		Class<DTO> dtoClass = (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

		BeanUtils.copyProperties(entity,dto);
		return	dto;
	}

	@GetMapping("/{id}")
	public T retrieveById(@PathVariable ID id ) {
		return	genericService.retrieveById(id);
	}

	@GetMapping()
	public Iterable<T> retrieveAll() {
		return	genericService.retrieveAll();
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@PathVariable ID id) {
		return	genericService.delete(id);
	}
}
