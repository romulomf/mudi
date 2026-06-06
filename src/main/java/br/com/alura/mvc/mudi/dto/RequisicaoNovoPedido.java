package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequisicaoNovoPedido {

	@NotBlank
	private String nomeProduto;

	@NotBlank
	private String urlProduto;

	@NotBlank
	private String urlImagem;

	private String descricao;

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNome(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
}