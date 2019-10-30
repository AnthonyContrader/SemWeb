package it.contrader.service;

import java.util.List;

import it.contrader.converter.DictionaryConverter;
import it.contrader.dao.DictionaryDAO;
import it.contrader.dto.DictionaryDTO;


public class DictionaryService {
	
	private DictionaryDAO dictionaryDAO;
	private DictionaryConverter dictionaryConverter;
	
	//Istanzio DAO  e Converter specifici.
	public DictionaryService(){
		this.dictionaryDAO = new DictionaryDAO();
		this.dictionaryConverter = new DictionaryConverter();
	}
	

	public List<DictionaryDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return dictionaryConverter.toDTOList(dictionaryDAO.getAll());
	}


	public DictionaryDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return dictionaryConverter.toDTO(dictionaryDAO.read(id));
	}


	public boolean insert(DictionaryDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return dictionaryDAO.insert(dictionaryConverter.toEntity(dto));
	}


	public boolean update(DictionaryDTO dto) {
		// Converte un researchDTO in entità e lo passa al researchDAO per la modifica
		return dictionaryDAO.update(dictionaryConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return dictionaryDAO.delete(id);
	}
}
