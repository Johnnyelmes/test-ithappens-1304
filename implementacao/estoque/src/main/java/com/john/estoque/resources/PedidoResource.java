package com.john.estoque.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.john.estoque.domain.Pedido;
import com.john.estoque.dto.PedidoNewDTO;
import com.john.estoque.services.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Controle de Estoque")
@RestController
@RequestMapping(value="pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;

	@ApiOperation(value="Retorna um unico Pedido")
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@ApiOperation(value="Insere um Pedido")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PedidoNewDTO objDto){
		Pedido obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
