package com.john.estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.estoque.domain.Produto;
import com.john.estoque.repositories.ProdutoRepository;
import com.john.estoque.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;

     public Produto buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
		}
     
     public List<Produto> findAll(){
 		return repo.findAll();
 	}
     
     public List<Produto> search(String descricao){
 		return repo.search(descricao);
 	}

}
