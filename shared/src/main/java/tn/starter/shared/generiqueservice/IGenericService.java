package tn.starter.shared.generiqueservice;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface IGenericService<DTO,T,ID> {

	DTO add(DTO dto);
	DTO update(DTO dto);
	DTO retrieveById(ID id);


	DTO patchUpdate(Map<Object, Object> fields, ID id);

	List<DTO> retrieveAll();
	Boolean delete(ID id);
	
}
