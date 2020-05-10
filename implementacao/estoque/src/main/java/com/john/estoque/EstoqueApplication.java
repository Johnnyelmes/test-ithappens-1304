package com.john.estoque;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.john.estoque.domain.Cliente;
import com.john.estoque.domain.Filial;
import com.john.estoque.domain.FilialProduto;
import com.john.estoque.domain.ItemPedido;
import com.john.estoque.domain.Pedido;
import com.john.estoque.domain.Produto;
import com.john.estoque.domain.Usuario;
import com.john.estoque.domain.enums.FormaPagamento;
import com.john.estoque.domain.enums.StatusProduto;
import com.john.estoque.domain.enums.TipoPedido;
import com.john.estoque.repositories.ClienteRepository;
import com.john.estoque.repositories.FilialProdutoRepository;
import com.john.estoque.repositories.FilialRepository;
import com.john.estoque.repositories.ItemPedidoRepository;
import com.john.estoque.repositories.PedidoRepository;
import com.john.estoque.repositories.ProdutoRepository;
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
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FilialProdutoRepository filialProdutoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, 200.00, sdf.parse("20/10/2000 08:00"),usu1,fil1, null, TipoPedido.ENTRADA, FormaPagamento.DINHEIRO);
		Pedido ped2 = new Pedido(null, 300.00, sdf.parse("30/11/2000 09:00"),usu1,fil1, null, TipoPedido.ENTRADA, FormaPagamento.CARTAO);
		Pedido ped3 = new Pedido(null, 800.00, sdf.parse("23/05/2000 10:30"),usu2,fil2, null, TipoPedido.ENTRADA, FormaPagamento.DINHEIRO);
		Pedido ped4 = new Pedido(null, 550.00, sdf.parse("07/07/2000 11:05") ,usu3,null, cli4, TipoPedido.SAIDA, FormaPagamento.DINHEIRO);
		Pedido ped5 = new Pedido(null, 730.00, sdf.parse("20/12/2000 20:00"),usu4,null, cli5, TipoPedido.SAIDA, FormaPagamento.CARTAO);
		Pedido ped6 = new Pedido(null, 730.00, sdf.parse("13/02/2000 12:30"),usu4,null, cli5, TipoPedido.SAIDA, FormaPagamento.CARTAO);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4,ped5, ped6));
		
		
		Produto pro1 = new Produto(null, "Cafe", 4.0, "123456");
		Produto pro2 = new Produto(null, "Leite", 2.0, "123777");
		Produto pro3 = new Produto(null, "Arroz", 12.0, "999436");
		Produto pro4 = new Produto(null, "Cha", 1.0, "683022");
		Produto pro5 = new Produto(null, "Feijao", 7.0, "273546");
		Produto pro6 = new Produto(null, "Canela", 3.0, "783200");
		
		
		produtoRepository.saveAll(Arrays.asList(pro1, pro2, pro3,pro4, pro5, pro6));
		
		FilialProduto fip1 = new FilialProduto(null, 20.00, pro1, fil1);
		FilialProduto fip2 = new FilialProduto(null, 10.00, pro2, fil1);
		FilialProduto fip3 = new FilialProduto(null, 15.00, pro3, fil1);
		
		FilialProduto fip4 = new FilialProduto(null, 25.00, pro1, fil2);
		FilialProduto fip5 = new FilialProduto(null, 65.00, pro4, fil2);
		
		FilialProduto fip6 = new FilialProduto(null, 12.00, pro3, fil3);
		FilialProduto fip7 = new FilialProduto(null, 11.00, pro5, fil4);
		FilialProduto fip8 = new FilialProduto(null, 5.00, pro6, fil5);
		
		filialProdutoRepository.saveAll(Arrays.asList(fip1,fip2,fip3,fip4,fip5,fip6,fip7,fip8));
		
	
		
		ItemPedido ip1 = new ItemPedido(null,50.0,2,ped1,fip4, StatusProduto.ATIVO);
		ItemPedido ip2 = new ItemPedido(null,120.0,3,ped2,fip3, StatusProduto.CANCELADDO);
		ItemPedido ip3 = new ItemPedido(null,180.0,4,ped5,fip1, StatusProduto.PROCESSADO);
		ItemPedido ip4 = new ItemPedido(null,30.0,2,ped4,fip2, StatusProduto.ATIVO);
		ItemPedido ip5 = new ItemPedido(null,800.0,1,ped3,fip5, StatusProduto.PROCESSADO);
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4,ip5));
	}
		
	

}
