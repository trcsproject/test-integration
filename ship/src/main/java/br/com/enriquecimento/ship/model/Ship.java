package br.com.enriquecimento.ship.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship {

	private String status;
	private String id;
	private Date data;
	private String cpfCnpj;
	private String produto;
	
}
