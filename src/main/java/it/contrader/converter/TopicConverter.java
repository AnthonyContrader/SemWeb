package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TopicDTO;
import it.contrader.model.Topic;

@Component
public class TopicConverter extends AbstractConverter<Topic, TopicDTO> {

	@Override
	public Topic toEntity(TopicDTO dto) {
		Topic t = null;
		if(dto != null) {
			t = new Topic(dto.getId(), dto.getKeywords());
		}
		return t;		
	}

	@Override
	public TopicDTO toDTO(Topic t) {
		TopicDTO dto = null;
		if(t != null) {
			dto = new TopicDTO(t.getId(), t.getKeywords());
		}
		return dto;
	}
	
	

}
