package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestScope
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

	private final PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model, Principal principal) {
		PageRequest criterio = PageRequest.of(0, 1, Sort.by(Pedido::getDataDeEntrega).descending());
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, criterio);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}