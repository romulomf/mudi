package br.com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Acesso {

	private String caminho;

	private LocalDateTime data;

	private Duration duracao;

	public Acesso(String caminho, LocalDateTime data) {
		this();
		this.caminho = caminho;
		this.data = data;
	}
}
