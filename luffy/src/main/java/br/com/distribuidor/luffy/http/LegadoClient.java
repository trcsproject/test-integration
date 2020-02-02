package br.com.distribuidor.luffy.http;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.distribuidor.luffy.dto.LegadoDto;
import br.com.distribuidor.luffy.model.Luffy;

@Service
public class LegadoClient {
	
	private RestTemplate restTemplate;
	
	public LegadoClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Luffy requestLegado() {
		String url = "https://chqop.getsandbox.com:443/alertas";
		ResponseEntity<LegadoDto> legado = restTemplate.postForEntity(url, null, LegadoDto.class);
		return new Luffy(legado.getBody());
	}
}
