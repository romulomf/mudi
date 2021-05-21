package br.com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;

public class Acesso {

	private String caminho;

	private LocalDateTime data;

	private Duration duracao;

	public Acesso() {
		// construtor padrão
	}

	public Acesso(String caminho, LocalDateTime data) {
		this();
		this.caminho = caminho;
		this.data = data;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public void setDuracao(Duration duracao) {
		this.duracao = duracao;
	}
}
