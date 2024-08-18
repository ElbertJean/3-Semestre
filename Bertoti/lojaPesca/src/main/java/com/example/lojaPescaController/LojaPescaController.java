package com.example.lojaPescaController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lojaPesca.LojaPesca;

@RestController
@RequestMapping("/loja-pesca")
class LojaPescaController {

	private List<LojaPesca> lojaPesca = new ArrayList<>();
	
	public LojaPescaController() {
		lojaPesca.addAll(List.of(
			new LojaPesca("1", "Maruri", "0.35mm"),
			new LojaPesca("2", "Shimano", "0.25mm"),
			new LojaPesca("3", "Lider", "0.40mm")
		));
	}
	
	// Pega todos os items
	@GetMapping
	public Iterable<LojaPesca> getItemsLoja() {
	    return lojaPesca;
	}
	
	// Pega um item em específico por ID
	@GetMapping("/{id}") 
	public Optional<LojaPesca> getItem(@PathVariable String id){
		for(LojaPesca item: lojaPesca) {
			if (item.getId().equals(id)) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}
	
	// Cria um novo item
	@PostMapping
	public ResponseEntity<String> postItem(@RequestBody LojaPesca lojaPesca) {
		if (lojaPesca == null || lojaPesca.getId() == null || lojaPesca.getId().isEmpty()
			|| lojaPesca.getLineMark() == null || lojaPesca.getLineMark().isEmpty() 
			|| lojaPesca.getMmLine() == null  || lojaPesca.getMmLine().isEmpty()) 
		{
			return new ResponseEntity<>("O corpo do objeto está vazio ou incompleto.", HttpStatus.BAD_REQUEST);
		}
		
		boolean added = this.lojaPesca.add(lojaPesca);
	
		if (added ) {
			return new ResponseEntity<>("Item adicionado com sucesso: " + lojaPesca.getId(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Erro ao adicionar o item.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Atualiza um item
	@PutMapping("/{id}")
	ResponseEntity<LojaPesca> putItem(@PathVariable String id, @RequestBody LojaPesca lojaPesca) {
		int itemIndex = -1;
		
		for (LojaPesca item: this.lojaPesca) {
			if (item.getId().equals(id)) {
				itemIndex = this.lojaPesca.indexOf(item);
				this.lojaPesca.set(itemIndex, lojaPesca);
				return new ResponseEntity<>(lojaPesca, HttpStatus.OK);
			}
		}
		
		this.lojaPesca.add(lojaPesca);
		return new ResponseEntity<>(lojaPesca, HttpStatus.CREATED);
	}
	
	// Deleta um item por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable String id) {
		boolean deleted = this.lojaPesca.removeIf(item -> item.getId().equals(id));

		if (deleted) {
			return new ResponseEntity<>("Item " + id + " deletado com sucesso!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erro ao tentar deletar o item " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Deleta todos os itens
	@DeleteMapping
	public ResponseEntity<String> deleteAllItems() {
		this.lojaPesca.clear();
		
		if (this.lojaPesca.isEmpty()) {
			return new ResponseEntity<>("Todos os itens foram deletados com sucesso.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erro ao tentar deletar os itens.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
