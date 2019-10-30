package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.ResearchDTO;
import it.contrader.model.Research;


public class ResearchConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public ResearchDTO toDTO(Research research) {
		ResearchDTO researchDTO = new ResearchDTO(research.getId(), research.getKeyWord());
		return researchDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Research toEntity(ResearchDTO researchDTO) {
		Research research = new Research(researchDTO.getId(), researchDTO.getKeyWord());
		return research;
	}
	
	/**
	 * Metodo per convertire le liste di Research.
	 */
	public List<ResearchDTO> toDTOList(List<Research> researchList) {
		//Crea una lista vuota.
		List<ResearchDTO> researchDTOList = new ArrayList<ResearchDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Research research : researchList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			researchDTOList.add(toDTO(research));
		}
		return researchDTOList;
	}
}
