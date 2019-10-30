package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DictionaryDTO;
import it.contrader.model.Dictionary;


public class DictionaryConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public DictionaryDTO toDTO(Dictionary dictionary) {
		DictionaryDTO dictionaryDTO = new DictionaryDTO(dictionary.getId(), dictionary.getName());
		return dictionaryDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Dictionary toEntity(DictionaryDTO dictionaryDTO) {
		Dictionary dictionary = new Dictionary(dictionaryDTO.getId(), dictionaryDTO.getName());
		return dictionary;
	}
	
	/**
	 * Metodo per convertire le liste di Research.
	 */
	public List<DictionaryDTO> toDTOList(List<Dictionary> dictionaryList) {
		//Crea una lista vuota.
		List<DictionaryDTO> dictionaryDTOList = new ArrayList<DictionaryDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Dictionary dictionary : dictionaryList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			dictionaryDTOList.add(toDTO(dictionary));
		}
		return dictionaryDTOList;
	}
}
