package br.com.distribuidor.luffy.model;

import java.util.Date;

import br.com.distribuidor.luffy.dto.LegadoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Luffy {

	public Luffy(LegadoDto d) {
		this(d.getId(), d.getData(), d.getCpfCnpj(), d.getProduto());
	}

	private String id;
	private Date data;
	private String cpfCnpj;
	private String produto;

}
