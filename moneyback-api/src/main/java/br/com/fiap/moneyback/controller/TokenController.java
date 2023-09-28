package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.repositories.TokenRepository;

@RequestMapping("/token") 
@RestController
public class TokenController extends AbstractCrudController<Token, TokenRepository> {

}
