package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.interceptor.Acesso;
import br.com.alura.mvc.mudi.interceptor.InterceptadorDeAcessos;

@RestController
@RequestMapping("/api/acessos")
public class AcessosRest {

	public AcessosRest() {
		// construtor padrão
	}

	@GetMapping
	public List<Acesso> getAcessos() {
		return InterceptadorDeAcessos.getAcessos();
	}
}