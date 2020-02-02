package br.com.distribuidor.luffy.dto;

import java.util.Date;

import br.com.distribuidor.luffy.model.Luffy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LuffyDto {
	
	private String id;
	private Date data;
	private String Produto;
	
	public LuffyDto(Luffy l){
		this(l.getId(), l.getData(), l.getProduto());
	}
}
