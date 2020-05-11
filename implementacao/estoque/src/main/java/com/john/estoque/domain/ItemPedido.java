package com.john.estoque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.john.estoque.domain.enums.StatusProduto;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double valorPedido;
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "filialProduto_id")
	private FilialProduto filialProduto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	private Integer status;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Integer id, Double valorPedido, Integer quantidade, Pedido pedido, FilialProduto filialProduto,
			StatusProduto status) {
		super();
		this.id = id;
		this.valorPedido = valorPedido;
		this.quantidade = quantidade;
		this.filialProduto = filialProduto;
		this.pedido = pedido;
		this.status = status.getCod();
	}
	
	public double getSubTotal() {
		return (filialProduto.getProduto().getPreco() * quantidade);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return this.getFilialProduto().getProduto();
	}

	@JsonIgnore
	public FilialProduto getFilialProduto() {
		return filialProduto;
	}

	public void setFilialProduto(FilialProduto filialProduto) {
		this.filialProduto = filialProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public StatusProduto getStatus() {
		return StatusProduto.toEnum(status);
	}

	public void setStatusProduto(Integer statusProduto) {
		this.status = statusProduto;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
