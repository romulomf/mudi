package br.com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class InterceptadorDeAcessos implements HandlerInterceptor {

	private static List<Acesso> acessos = new ArrayList<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Acesso acesso = new Acesso(request.getRequestURI(), LocalDateTime.now());
		request.setAttribute("acesso", acesso);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.setDuracao(Duration.between(acesso.getData(), LocalDateTime.now()));
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	public static List<Acesso> getAcessos() {
		return acessos;
	}
}