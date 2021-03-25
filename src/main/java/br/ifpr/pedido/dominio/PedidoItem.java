package br.ifpr.pedido.dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.util.StringUtils;

@Entity
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer quantidade;
	private double valor;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Pedido pedido;

	public PedidoItem() {
		this.quantidade = 1;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getNomeProduto() {
		if (this.produto != null) {
			return this.produto.getNome();
		}
		return "";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "quant [quantidade=" + quantidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		return Objects.equals(id, other.id);
	}

	public boolean isVazio() {
		return !StringUtils.hasText(quantidade.toString());
	}

}
