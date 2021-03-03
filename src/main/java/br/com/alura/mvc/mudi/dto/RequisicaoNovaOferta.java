package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {

	private Long pedidoId;

	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	private String valor;

	@NotNull
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
	private String dataDeEntrega;

	private String comentario;

	public RequisicaoNovaOferta() {
		// construtor padrão
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(String dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setValor(new BigDecimal(this.valor));
		oferta.setDataDeEntrega(LocalDate.parse(this.dataDeEntrega, DateTimeFormatter.ISO_LOCAL_DATE));
		oferta.setComentario(this.comentario);
		return oferta;
	}
}