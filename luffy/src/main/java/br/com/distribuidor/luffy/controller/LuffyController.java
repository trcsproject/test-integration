package br.com.distribuidor.luffy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidor.luffy.dto.LuffyDto;
import br.com.distribuidor.luffy.http.LegadoClient;
import br.com.distribuidor.luffy.http.LuffyClient;
import br.com.distribuidor.luffy.http.LuffyClientAsync;
import br.com.distribuidor.luffy.model.Luffy;
import br.com.distribuidor.luffy.mq.NotificarFilaMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
public class LuffyController {
	
	@Autowired
	private LegadoClient legadoClient;
	
	private LuffyClient luffyClient;
	
	private NotificarFilaMQ filaMQ;
	
	@Autowired
	private LuffyClientAsync luffyClientAsync;
	
	@GetMapping("/start")
	@ResponseBody
	public Luffy consomeLegado() throws InterruptedException{
		
		log.info("Executando Rotina!");
		
		//Busca Legado
		Luffy luffy = legadoClient.requestLegado();
		log.info("Recebido os dados do legado! " + luffy.toString());
		
		//Envia Enrequecimento ASYNC
		//luffyClient.enviaAlerta(new LuffyDto(luffy));
		luffyClientAsync.enviaAlerta(new LuffyDto(luffy));
		log.info("enviado para ser processado! ");
		
		//Posta na fila
		filaMQ.enviaMensagemParaFila(luffy);
		
		return luffy;
	}
	
	
	
}
