package it.contrader.service;

import java.util.List;


import it.contrader.converter.ResearchConverter;
import it.contrader.dao.ResearchDAO;
import it.contrader.dto.ResearchDTO;


public class ResearchService {
	
	private ResearchDAO researchDAO;
	private ResearchConverter researchConverter;
	
	//Istanzio DAO  e Converter specifici.
	public ResearchService(){
		this.researchDAO = new ResearchDAO();
		this.researchConverter = new ResearchConverter();
	}
	

	public List<ResearchDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return researchConverter.toDTOList(researchDAO.getAll());
	}


	public ResearchDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return researchConverter.toDTO(researchDAO.read(id));
	}


	public boolean insert(ResearchDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return researchDAO.insert(researchConverter.toEntity(dto));
	}


	public boolean update(ResearchDTO dto) {
		// Converte un researchDTO in entità e lo passa al researchDAO per la modifica
		return researchDAO.update(researchConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return researchDAO.delete(id);
	}
}
