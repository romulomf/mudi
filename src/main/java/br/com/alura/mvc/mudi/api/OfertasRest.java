package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/ofertas")
@NoArgsConstructor
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		Optional<Pedido> resultado = pedidoRepository.findById(requisicao.getPedidoId());
		Oferta oferta = null;
		if (resultado.isPresent()) {
			Pedido pedido = resultado.get();
			oferta = requisicao.toOferta();
			oferta.setPedido(pedido);
			pedido.getOfertas().add(oferta);
			pedidoRepository.save(pedido);
		}
		return oferta;
	}
}