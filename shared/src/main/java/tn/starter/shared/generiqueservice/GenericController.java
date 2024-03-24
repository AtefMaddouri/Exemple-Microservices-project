package tn.starter.shared.generiqueservice;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class GenericController<DTO, T,ID> {
	@Autowired
	IGenericService<DTO,T,ID> genericService;


	@PostMapping
	public DTO add(@RequestBody DTO dto) {
		return genericService.add(dto);
	}

	@PutMapping
	public DTO update(@RequestBody DTO dto) {
		return genericService.update(dto);
	}

	@PatchMapping("{id}")
	public DTO patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable("id") ID id){
		return genericService.patchUpdate(fields,id);
	}
	@GetMapping("/{id}")
	public DTO retrieveById(@PathVariable("id") ID id ) {
		return	genericService.retrieveById(id);
	}

	@GetMapping()
	public List<DTO> retrieveAll() {
		return	genericService.retrieveAll();
	}

	@DeleteMapping("/{id}")
	public Boolean delete(@PathVariable("id") ID id) {
		return	genericService.delete(id);
	}
}
