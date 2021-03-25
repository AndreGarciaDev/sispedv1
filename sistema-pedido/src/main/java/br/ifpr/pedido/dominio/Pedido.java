package br.ifpr.pedido.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate data;

	@OneToMany
	(
		cascade = CascadeType.ALL, 
		orphanRemoval = true,
		mappedBy = "pedido",
		fetch = FetchType.EAGER
	)
	private List<PedidoItem> itens = new ArrayList<>();
	
	@Deprecated
	protected Pedido() {
		this.data = LocalDate.now();
	}
	
	public Pedido(final LocalDate data) {
		this.data = data;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void addPedidoItem(PedidoItem item) {
		this.itens.add(item);
		item.setPedido(this);
	}
	
	public void removePedidoItem(PedidoItem item) {
		this.itens.remove(item);
		item.setPedido(null);
	}
	
	public void removePedidoItem(int index) {
		PedidoItem item = this.itens.get(index);
		if (item != null) {
			this.itens.remove(index);
			item.setPedido(null);
		}
	}
	
	public List<PedidoItem> getItens() {
		return this.itens;
	}
	
	@Override // !!!!!
	public String toString() {
		return "Pedido [data=" + data + "]";
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
