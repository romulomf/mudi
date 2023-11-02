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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PEDIDOS")
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@JsonProperty("nome")
	@Column(name = "NOME", nullable = false)
	private String nome;

	@JsonProperty("valor")
	@Column(name = "VALOR", nullable = true)
	private BigDecimal valor;

	@JsonProperty("dataDeEntrega")
	@Column(name = "DATA_ENTREGA", nullable = true)
	private LocalDate dataDeEntrega;

	@JsonProperty("urlProduto")
	@Column(name = "URL_PRODUTO", columnDefinition = "TEXT", nullable = false)
	private String urlProduto;

	@JsonProperty("urlImagem")
	@Column(name = "URL_IMAGEM", columnDefinition = "TEXT", nullable = false)
	private String urlImagem;

	@JsonProperty("descricao")
	@Column(name = "DESCRICAO", columnDefinition = "TEXT", nullable = true)
	private String descricao;

	@JsonProperty("status")
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusPedido status;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "PEDIDO", fetch = FetchType.LAZY)
	private List<Oferta> ofertas;

	public synchronized StatusPedido getStatus() {
		return status;
	}

	public synchronized void setStatus(StatusPedido status) {
		this.status = status;
	}
}