package com.john.estoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.estoque.domain.Produto;
import com.john.estoque.resources.utils.URL;
import com.john.estoque.services.ProdutoService;

@RestController
@RequestMapping(value="produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;

	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> findALL(
			@RequestParam(value="descricao",defaultValue="") String descricao) {
		String descricaoDecode = URL.decodeParam(descricao);
		List<Produto> list = service.search(descricaoDecode);
		return ResponseEntity.ok().body(list);
	}
	
}
