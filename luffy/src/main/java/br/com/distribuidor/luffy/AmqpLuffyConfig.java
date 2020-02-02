package br.com.distribuidor.luffy;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

import br.com.distribuidor.luffy.AmqpLuffyConfig.LuffySource;

@EnableBinding(LuffySource.class)
@Configuration
public class AmqpLuffyConfig {

	public static interface LuffySource {
		@Output
		MessageChannel luffyProcessor();
	}
}
