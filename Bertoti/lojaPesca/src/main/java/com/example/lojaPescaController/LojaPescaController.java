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
	
	@GetMapping
	public Iterable<LojaPesca> getItemsLoja() {
	    return lojaPesca;
	}
	
	@GetMapping("/{id}") 
	public Optional<LojaPesca> getItem(@PathVariable String id){
		for(LojaPesca item: lojaPesca) {
			if (item.getId().equals(id)) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping
	public LojaPesca postItem(@RequestBody LojaPesca lojaPesca) {
		this.lojaPesca.add(lojaPesca);
		return lojaPesca;
	}
	
	@PutMapping
	ResponseEntity<LojaPesca> putItem(@PathVariable String id, @RequestBody LojaPesca lojaPesca) {
		int itemIndex = -1;
		
		for (LojaPesca item: this.lojaPesca) {
			if (item.getId().equals(id)) {
				itemIndex = this.lojaPesca.indexOf(item);
				this.lojaPesca.set(itemIndex, lojaPesca);
			}
		}
		
		return(itemIndex == -1) ?
				new ResponseEntity<LojaPesca>(postItem(lojaPesca), HttpStatus.CREATED) : 
				new ResponseEntity<LojaPesca>(lojaPesca, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable String id) {
		this.lojaPesca.removeIf(item -> item.getId().equals(id));
	}
	
	
}
