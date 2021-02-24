package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {

	@NotBlank
	private String nomeProduto;

	@NotBlank
	private String urlProduto;

	@NotBlank
	private String urlImagem;

	private String descricao;

	public RequisicaoNovoPedido() {
		// construtor padrão
	}

	public synchronized String getNomeProduto() {
		return nomeProduto;
	}

	public synchronized void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public synchronized String getUrlProduto() {
		return urlProduto;
	}

	public synchronized void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public synchronized String getUrlImagem() {
		return urlImagem;
	}

	public synchronized void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public synchronized String getDescricao() {
		return descricao;
	}

	public synchronized void setDescricao(String descricao) {
		this.descricao = descricao;
	}

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