package br.com.enriquecimento.ship.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.enriquecimento.ship.model.Luffy;
import br.com.enriquecimento.ship.model.Ship;
import lombok.extern.slf4j.Slf4j;

@RestController
@ResponseBody
@Slf4j
public class ShipController {

	@PostMapping("/enrequicimento/alerta")
	public Ship enrequicimento(@RequestBody Luffy lufy){
		log.info("processado! " + lufy.toString());
		return new Ship("processado", lufy.getId(), lufy.getData(), lufy.getCpfCnpj(), lufy.getProduto());
	}
	
}
