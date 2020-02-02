package br.com.distribuidor.luffy.mq;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.distribuidor.luffy.AmqpLuffyConfig.LuffySource;
import br.com.distribuidor.luffy.dto.LuffyDto;
import br.com.distribuidor.luffy.model.Luffy;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificarFilaMQ {

	private LuffySource source;

	public void enviaMensagemParaFila(Luffy luffy) {
		LuffyDto dto = new LuffyDto(luffy);
		source.luffyProcessor().send(MessageBuilder.withPayload(dto).build());
	}

}
