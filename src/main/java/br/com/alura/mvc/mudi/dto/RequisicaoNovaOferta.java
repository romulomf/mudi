package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequisicaoNovaOferta {

	private Long pedidoId;

	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	private String valor;

	@NotNull
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
	private String dataDeEntrega;

	private String comentario;

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setValor(new BigDecimal(this.valor));
		oferta.setDataDeEntrega(LocalDate.parse(this.dataDeEntrega, DateTimeFormatter.ISO_LOCAL_DATE));
		oferta.setComentario(this.comentario);
		return oferta;
	}
}