package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidosRest() {
		// construtor padrão
	}

	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		Sort ordenacao = Sort.by("id").descending();
		PageRequest criterio = PageRequest.of(0, 10, ordenacao);
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, criterio);
	}
}