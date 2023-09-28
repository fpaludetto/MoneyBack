package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.Categoria;
import br.com.fiap.moneyback.repositories.CategoriaRepository;

@RequestMapping("/categoria") 
@RestController 
public class CategoriaController extends AbstractCrudController<Categoria, CategoriaRepository> {

	
}
