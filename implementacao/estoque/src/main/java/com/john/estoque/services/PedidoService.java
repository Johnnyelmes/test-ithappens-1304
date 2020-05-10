package com.john.estoque.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.john.estoque.domain.Cliente;
import com.john.estoque.domain.FilialProduto;
import com.john.estoque.domain.ItemPedido;
import com.john.estoque.domain.Pedido;
import com.john.estoque.domain.Usuario;
import com.john.estoque.domain.enums.FormaPagamento;
import com.john.estoque.domain.enums.StatusProduto;
import com.john.estoque.domain.enums.TipoPedido;
import com.john.estoque.dto.PedidoNewDTO;
import com.john.estoque.repositories.ItemPedidoRepository;
import com.john.estoque.repositories.PedidoRepository;
import com.john.estoque.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Pedido não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj = repo.save(obj);
		itemPedidoRepository.saveAll(obj.getItemPedidos());
		return obj;
	}

	public Pedido fromDTO(PedidoNewDTO objDto) {
		
		Usuario user = new Usuario(objDto.getUsuarioId(), null);
		Cliente cli = new Cliente(objDto.getClienteId(), null);
		FilialProduto filp = new FilialProduto(objDto.getFilialProdutoId(), null, null, null);
		Pedido ped = new Pedido(null, objDto.getValorFinal(), new Date(), user, null, cli, TipoPedido.toEnum(objDto.getTipo()), FormaPagamento.toEnum(objDto.getForma()));
		ItemPedido itp = new ItemPedido(null, objDto.getValorPedido(), objDto.getQuantidade(), ped, filp, StatusProduto.toEnum(objDto.getStatus()));
		ped.getItemPedidos().add(itp);
		 
		return ped;
	}
}
