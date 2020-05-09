package com.john.estoque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.john.estoque.domain.enums.FormaPagamento;
import com.john.estoque.domain.enums.TipoPedido;

@Entity
public class Pedido  implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valorFinal;
	
	//private Usuario usuario;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="filial_id")
	private Filial filial;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	private Integer tipo;
	private Integer forma;
	
	public Pedido() {
		super();
	}
	
	public Pedido(Integer id, Double valorFinal, Filial filial, Cliente cliente, TipoPedido tipoPedido, FormaPagamento formaPagamento) {
		super();
		this.id = id;
		this.valorFinal = valorFinal;
		//this.usuario = usuario;
		this.filial = filial;
		this.cliente = cliente;
		this.tipo = tipoPedido.getCod();
		this.forma = formaPagamento.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	//public Usuario getUsuario() {
	//	return usuario;
	//}

	//public void setUsuario(Usuario usuario) {
	//	this.usuario = usuario;
	//}

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

	public void setFormaPagamento(Integer formaPagamento) {
		this.forma = formaPagamento;
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
