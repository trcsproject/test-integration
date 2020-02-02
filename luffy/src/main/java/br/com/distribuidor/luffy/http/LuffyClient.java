package br.com.distribuidor.luffy.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.distribuidor.luffy.dto.LuffyDto;

@Async
@FeignClient(url = "${configuracao.ship.service.url}", name = "enrequicimento")
public interface LuffyClient {

	@PostMapping("/enrequicimento/alerta")
	void enviaAlerta(LuffyDto luffyDto);

}