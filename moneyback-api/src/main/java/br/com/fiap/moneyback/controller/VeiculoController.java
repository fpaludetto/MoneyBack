package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.Veiculo;
import br.com.fiap.moneyback.repositories.VeiculoRepository;

@RequestMapping("/veiculo") 
@RestController 
public class VeiculoController extends AbstractCrudController<Veiculo, VeiculoRepository> {

}
