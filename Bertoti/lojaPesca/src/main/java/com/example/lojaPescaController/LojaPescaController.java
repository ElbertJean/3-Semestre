package com.example.lojaPescaController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lojaPesca.LojaPesca;

@RestController
@RequestMapping("/loja-pesca")
class LojaPescaController {

	private List<LojaPesca> lojaPesca = new ArrayList<>();
	
	public LojaPescaController() {
		lojaPesca.addAll(List.of(
			new LojaPesca("1", "Maruri", "0.35mm")
		));
	}
	
	@GetMapping
	public Iterable<LojaPesca> getLojaPesca() {
	    return lojaPesca;
	}
}
