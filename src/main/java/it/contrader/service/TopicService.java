package it.contrader.service;

import java.util.List;

import it.contrader.converter.TopicConverter;
import it.contrader.dao.TopicDAO;
import it.contrader.dto.TopicDTO;


public class TopicService {
	
	private TopicDAO topicDAO;
	private TopicConverter topicConverter;
	
	//Istanzio DAO  e Converter specifici.
	public TopicService(){
		this.topicDAO = new TopicDAO();
		this.topicConverter = new TopicConverter();
	}
	

	public List<TopicDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return topicConverter.toDTOList(topicDAO.getAll());
	}


	public TopicDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return topicConverter.toDTO(topicDAO.read(id));
	}


	public boolean insert(TopicDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return topicDAO.insert(topicConverter.toEntity(dto));
	}


	public boolean update(TopicDTO dto) {
		// Converte un topicDTO in entità e lo passa al topicDAO per la modifica
		return topicDAO.update(topicConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return topicDAO.delete(id);
	}
}