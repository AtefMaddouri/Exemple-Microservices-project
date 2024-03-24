package tn.starter.shared.generiqueservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Slf4j
public class IGenericServiceImp<DTO,T,ID> implements IGenericService<DTO,T,ID> {

	@Autowired
	JpaRepository<T,ID> baseRepository;
	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	private final Class<DTO> dtoClass = (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];


	@Override
	public DTO add(DTO dto) {

		T entity = BeanUtils.instantiateClass(entityClass);
		BeanUtils.copyProperties(dto,entity);
		baseRepository.save(entity);
		log.info(entity.toString());

		BeanUtils.copyProperties(entity,dto);
		return dto;
	}

	@Override
	public DTO update(DTO dto) {

		T entity = BeanUtils.instantiateClass(entityClass);
		BeanUtils.copyProperties(dto,entity);

		baseRepository.save(entity);

		BeanUtils.copyProperties(entity,dto);
		return	dto;
	}

	@Override
	public DTO retrieveById(ID id) {

		T entity = baseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(" No Object Found with this id "));
		log.info(entity.toString());
		DTO dto = BeanUtils.instantiateClass(dtoClass);


		BeanUtils.copyProperties(entity,dto);
		log.info(dto.toString());
		return dto;
	}

	@Override
	public DTO patchUpdate(Map<Object, Object> fields, ID id) {

		T entity = baseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(" No Object found with this id "+ id));

		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(entityClass,(String) key);
			field.setAccessible(true);

			log.info(key + " " +field.getType()+"  "+value);

			if(field.getType().equals(LocalDate.class)){
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse((String) value, formatter);
				ReflectionUtils.setField(field, entity , localDate);
			}else {
				ReflectionUtils.setField(field, entity , value);
			}



		});

		baseRepository.save(entity);
		DTO dto = BeanUtils.instantiateClass(dtoClass);
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}


	@Override
	public List<DTO> retrieveAll() {

		return baseRepository.findAll().stream()
				.map(entity -> {
					DTO dto = BeanUtils.instantiateClass(dtoClass);
					BeanUtils.copyProperties(entity,dto);
					return dto;
				}).toList();
	}

	@Override
	public Boolean delete(ID id) {
		baseRepository.deleteById(id);
		return !baseRepository.existsById(id);
	}

}
