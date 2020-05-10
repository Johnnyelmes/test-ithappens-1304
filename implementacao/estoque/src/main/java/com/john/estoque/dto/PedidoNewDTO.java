package com.john.estoque.dto;

public class PedidoNewDTO {
	
    //Pedido
	private Double valorFinal;
	private Integer usuarioId;
	private Integer clienteId;
	private Integer tipo;
	private Integer forma;

	//itemPedido
	private Double valorPedido;
	private Integer quantidade;
	private Integer filialProdutoId;
	private Integer status;
	
	
	public PedidoNewDTO() {
	}


	public Double getValorFinal() {
		return valorFinal;
	}


	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


	public Integer getClienteId() {
		return clienteId;
	}


	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public Integer getForma() {
		return forma;
	}


	public void setForma(Integer forma) {
		this.forma = forma;
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


	public Integer getFilialProdutoId() {
		return filialProdutoId;
	}


	public void setFilialProdutoId(Integer filialProdutoId) {
		this.filialProdutoId = filialProdutoId;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
