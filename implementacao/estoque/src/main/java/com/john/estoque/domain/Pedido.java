package com.john.estoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.john.estoque.domain.enums.FormaPagamento;
import com.john.estoque.domain.enums.TipoPedido;

@Entity
public class Pedido  implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data;
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="filial_id")
	private Filial filial;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	private Integer tipo;
	private Integer forma;
	private String observacaoEntrega;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedidos =  new ArrayList<>();
	
	public Pedido() {
		super();
	}
	
	public Pedido(Integer id, Date data,Usuario usuario, Filial filial, Cliente cliente, TipoPedido tipoPedido, FormaPagamento formaPagamento, String observacaoEntrega) {
		super();
		this.id = id;
		this.data = data;
		this.usuario = usuario;
		this.filial = filial;
		this.cliente = cliente;
		this.tipo = tipoPedido.getCod();
		this.forma = formaPagamento.getCod();
		this.observacaoEntrega = observacaoEntrega;
	}
	
	public double getTotal() {
		double soma = 0.0;
		for(ItemPedido x  : itemPedidos) {
			soma +=  x.getFilialProduto().getProduto().getPreco() * x.getQuantidade();
		}
		return soma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	public TipoPedido getTipo() {
		return TipoPedido.toEnum(tipo);
	}

	public void setTipo(TipoPedido tipo) {
		this.tipo = tipo.getCod();
	}

	public FormaPagamento getForma() {
		return FormaPagamento.toEnum(forma);
	}

	public String getObservacaoEntrega() {
		return observacaoEntrega;
	}

	public void setObservacaoEntrega(String observacaoEntrega) {
		this.observacaoEntrega = observacaoEntrega;
	}

	public void setFormaPagamento(Integer formaPagamento) {
		this.forma = formaPagamento;
	}
	
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	

}
