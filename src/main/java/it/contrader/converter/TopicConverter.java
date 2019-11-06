package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TopicDTO;
import it.contrader.model.Topic;


public class TopicConverter   {
	
	/**
	 * Crea un oggetto di tipo TopicDTO e lo riempie con i campi del parametro topic di tipo Topic.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public TopicDTO toDTO(Topic topic) {
		TopicDTO topicDTO = new TopicDTO(topic.getId(), topic.getName());
		return topicDTO;
	}

	/**
	 * Crea un oggetto di tipo Topic e lo riempie con i campi del parametro topic di tipo TopicDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Topic toEntity(TopicDTO topicDTO) {
		Topic topic = new Topic(topicDTO.getId(), topicDTO.getName());
		return topic;
	}
	
	/**
	 * Metodo per convertire le liste di Topic.
	 */
	public List<TopicDTO> toDTOList(List<Topic> topicList) {
		//Crea una lista vuota.
		List<TopicDTO> topicDTOList = new ArrayList<TopicDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Topic topic : topicList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			topicDTOList.add(toDTO(topic));
		}
		return topicDTOList;
	}
}