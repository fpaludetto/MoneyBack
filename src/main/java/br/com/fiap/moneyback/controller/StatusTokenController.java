package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.StatusToken;
import br.com.fiap.moneyback.repositories.StatusTokenRepository;

@RequestMapping("/statusToken") 
@RestController 
public class StatusTokenController extends AbstractCrudController<StatusToken, StatusTokenRepository> {

}
