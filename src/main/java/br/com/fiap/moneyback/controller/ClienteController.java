package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.Cliente;
import br.com.fiap.moneyback.repositories.ClienteRepository;

@RequestMapping("/cliente") 
@RestController 
public class ClienteController extends AbstractCrudController<Cliente, ClienteRepository> {

}
