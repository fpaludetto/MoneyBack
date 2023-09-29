package br.com.fiap.moneyback.controller.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.ConfiguracaoCashback;
import br.com.fiap.moneyback.repositories.ConfiguracaoCashbackRepository;

@RequestMapping("/configuracao-cashback") 
@RestController 
public class ConfiguracaoCashbackController extends AbstractCrudController<ConfiguracaoCashback, ConfiguracaoCashbackRepository> {



}
