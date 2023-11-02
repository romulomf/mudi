package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OFERTAS")
@NoArgsConstructor
@Getter
@Setter
public class Oferta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;

	@Column(name = "DATA_ENTREGA", nullable = false)
	private LocalDate dataDeEntrega;

	@Column(name = "COMENTARIO", columnDefinition = "TEXT")
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PEDIDO_ID")
	private Pedido pedido;
}