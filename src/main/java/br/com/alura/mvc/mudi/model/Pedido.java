package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("nome")
	@Column(name = "nome", nullable = false)
	private String nome;

	@JsonProperty("valor")
	@Column(name = "valor", nullable = true)
	private BigDecimal valor;

	@JsonProperty("dataDeEntrega")
	@Column(name = "data_entrega", nullable = true)
	private LocalDate dataDeEntrega;

	@JsonProperty("urlProduto")
	@Column(name = "url_produto", columnDefinition = "TEXT", nullable = false)
	private String urlProduto;

	@JsonProperty("urlImagem")
	@Column(name = "url_imagem", columnDefinition = "TEXT", nullable = false)
	private String urlImagem;

	@JsonProperty("descricao")
	@Column(name = "descricao", columnDefinition = "TEXT", nullable = true)
	private String descricao;

	@JsonProperty("status")
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<Oferta> ofertas;

	public synchronized StatusPedido getStatus() {
		return status;
	}

	public synchronized void setStatus(StatusPedido status) {
		this.status = status;
	}
}