package com.john.estoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FilialProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	private Double preco ;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="filial_id")
	private Filial filial;
	
	@JsonIgnore
	@OneToMany(mappedBy = "filialProduto")
	private List<ItemPedido> itemPedidos = new ArrayList<>();
	
	public FilialProduto() {
		super();
	}


	public FilialProduto(Integer id, Double preco, Produto produto, Filial filial) {
		super();
		this.id = id;
		this.preco = preco;
		this.produto = produto;
		this.filial = filial;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	
	public List<ItemPedido> getItemPedido() {
		return itemPedidos;
	}

	public void setItemPedido(List<ItemPedido> itemPedidos) {
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
		FilialProduto other = (FilialProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
