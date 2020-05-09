package com.john.estoque;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.john.estoque.domain.Cliente;
import com.john.estoque.domain.Filial;
import com.john.estoque.domain.Pedido;
import com.john.estoque.domain.Usuario;
import com.john.estoque.domain.enums.FormaPagamento;
import com.john.estoque.domain.enums.TipoPedido;
import com.john.estoque.repositories.ClienteRepository;
import com.john.estoque.repositories.FilialRepository;
import com.john.estoque.repositories.PedidoRepository;
import com.john.estoque.repositories.UsuarioRepository;

@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FilialRepository filialRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class,  args);
	}


	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu1 = new Usuario(null, "Marcos");
		Usuario usu2 = new Usuario(null, "Jose");
		Usuario usu3 = new Usuario(null, "Alberto");
		Usuario usu4 = new Usuario(null, "Carlos");
		Usuario usu5 = new Usuario(null, "Maria");
		
		usuarioRepository.saveAll(Arrays.asList(usu1,usu2,usu3,usu4,usu5));

		Cliente cli1 = new Cliente(null, "Marcos");
		Cliente cli2 = new Cliente(null, "Jose");
		Cliente cli3 = new Cliente(null, "Alberto");
		Cliente cli4 = new Cliente(null, "Carlos");
		Cliente cli5 = new Cliente(null, "Maria");

		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
		
		
		Filial fil1 = new Filial(null, "Jpa construcoes");
		Filial fil2 = new Filial(null, "DG LTDA");
		Filial fil3 = new Filial(null, "Comercio Dois irmaos");
		Filial fil4 = new Filial(null, "Sadia");
		Filial fil5 = new Filial(null, "Perdigao");
		
		filialRepository.saveAll(Arrays.asList(fil1,fil2,fil3,fil4,fil5));
		
		
		Pedido ped1 = new Pedido(null, 200.00, fil1, cli1, TipoPedido.ENTRADA, FormaPagamento.DINHEIRO);
		Pedido ped2 = new Pedido(null, 300.00, fil1, cli2, TipoPedido.ENTRADA, FormaPagamento.CARTAO);
		Pedido ped3 = new Pedido(null, 800.00, fil2, cli3, TipoPedido.SAIDA, FormaPagamento.DINHEIRO);
		Pedido ped4 = new Pedido(null, 550.00, fil3, cli4, TipoPedido.SAIDA, FormaPagamento.DINHEIRO);
		Pedido ped5 = new Pedido(null, 730.00, fil5, cli5, TipoPedido.SAIDA, FormaPagamento.CARTAO);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4,ped5));
	}
		
	

}
