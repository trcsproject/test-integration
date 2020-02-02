package br.com.distribuidor.luffy.http;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.distribuidor.luffy.dto.LuffyDto;
import br.com.distribuidor.luffy.dto.ShipDto;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class LuffyClientAsync {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Async("asyncExecutor")
    public CompletableFuture<ShipDto> enviaAlerta(LuffyDto luffy) throws InterruptedException 
    {
        log.info("starts request ship");
 
        ShipDto dtoShip = restTemplate.postForObject("http://localhost:8082/enrequicimento/alerta", luffy, ShipDto.class);
 
        log.info("dtoShipData, {}", dtoShip);
        Thread.sleep(1000L);    //Intentional delay
        log.info("dtoShipData completed");
        return CompletableFuture.completedFuture(dtoShip);
    }

}
