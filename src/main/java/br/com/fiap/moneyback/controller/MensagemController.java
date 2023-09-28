package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.Mensagem;
import br.com.fiap.moneyback.repositories.MensagemRepository;

@RequestMapping("/mensagem") 
@RestController 
public class MensagemController extends AbstractCrudController<Mensagem, MensagemRepository> {

}
