package br.com.fiap.moneyback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.CashbackItem;
import br.com.fiap.moneyback.domain.CashbackToken;
import br.com.fiap.moneyback.domain.Cliente;
import br.com.fiap.moneyback.domain.ItemExtrato;
import br.com.fiap.moneyback.exception.BusinessException;
import br.com.fiap.moneyback.repositories.ClienteRepository;
import br.com.fiap.moneyback.repositories.ItemExtratoRepository;
import br.com.fiap.moneyback.service.CashbackService;
import jakarta.validation.constraints.NotNull;

@RequestMapping("/compra") 
@RestController 
public class CompraController  {

	@Autowired
	private ItemExtratoRepository itemRepository;
	
	@Autowired	
	private ClienteRepository clienteRepository;
	
	@Autowired	
	private CashbackService cashbackService;
	
	@GetMapping(path = "/total-cashback/{idCliente}")
	public Double calculaCashback(@PathVariable @NotNull String idCliente) {
		Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new BusinessException("Cliente não encontrado"));
		return cashbackService.getCashbackTotal(cliente, false);
	}
	
	@PostMapping(path = "/gera-cashback-token")
	public CashbackToken geraCashback(@RequestParam @NotNull String idCliente, @RequestParam @NotNull Double valorConsumo) {
		Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new BusinessException("Cliente não encontrado"));
		return cashbackService.geraCashbackToken(cliente, valorConsumo);
	}
	
	@GetMapping(path = "/lista-cashback/{idCliente}")
	public List<CashbackItem> listAll(@PathVariable String idCliente, @RequestParam @NotNull Boolean ativo){
		return cashbackService.listAll(idCliente, ativo);
	}
	
	@PostMapping
	public ItemExtrato executaAbastecimento(@RequestBody ItemExtrato item) {
		
		Cliente cliente = clienteRepository.findById(item.getCliente().getId()).orElseThrow(() -> new BusinessException("Cliente não encontrado"));
		item.setCliente(cliente);
		item.setValorTotal(item.getValorItem());
		
		CashbackItem cashbackItem = cashbackService.geraCashbackItem(cliente, item.getValorItem());
		if(cashbackItem != null) {
			item.setCashbackItem(cashbackItem);
			item.setValorCashback(cashbackItem.getValor());
		}
		
		//Aplica cashback se houver token do item. 
		if(item.getCashbackToken() != null) {
			CashbackToken token = cashbackService.findCachbackActiveClientToken(cliente, item.getCashbackToken().getId());
			
			item.setValorCashback(token.getValor());
			item.setValorTotal(item.getValorTotal() - item.getValorCashback());
			cashbackService.setTokenUsed(token);
		}
		
		return itemRepository.save(item);
		
	}
	
}



