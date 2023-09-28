package br.com.fiap.moneyback.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.moneyback.domain.IdentifiableDomain;
import jakarta.validation.constraints.NotNull;


public class AbstractCrudController<D extends IdentifiableDomain, R extends JpaRepository<D, String>>  {

	@Autowired
	private ApplicationContext appContext;

	
	private Class<R> getRepositoryClass() {
		return (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	public final R getRepository(){
		return this.appContext.getBean(this.getRepositoryClass());
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<D> findById(@PathVariable String id) {
		return ResponseEntity.of(getRepository().findById(id));
	}

	@PostMapping
	public ResponseEntity<D> post(@RequestBody @NotNull D model) {
		model.setId(null);
		return ResponseEntity.ofNullable(getRepository().save(model));
	}

	@PutMapping
	public void put(@RequestBody @NotNull D model) {
		getRepository().save(model);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable @NotNull String id) {
		if(getRepository().findById(id).orElse(null) == null) {
			return ResponseEntity.notFound().build();
		}
		getRepository().deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<D> findPageable(Pageable pageable) {
		return getRepository().findAll(pageable);
	}
	
	@GetMapping("/all")
	public List<D> findAll(){
		return getRepository().findAll();
	}
	
}
