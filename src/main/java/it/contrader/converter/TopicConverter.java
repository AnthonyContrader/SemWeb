package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TopicDTO;
import it.contrader.model.Topic;

@Component
public class TopicConverter extends AbstractConverter<Topic, TopicDTO> {

	@Override
	public Topic toEntity(TopicDTO topicDTO) {
		Topic topic = null;
		if(topicDTO != null)
		{
			topic = new Topic();
			topic.setId(topicDTO.getId());
			topic.setKeywords(topicDTO.getKeywords());
		}
		return topic;
	}

	@Override
	public TopicDTO toDTO(Topic topic) {
		TopicDTO topicDTO = null;
		if(topic != null)
		{			
			topicDTO = new TopicDTO();
			topicDTO.setId(topic.getId());
			topicDTO.setKeywords(topic.getKeywords());
		}
		return topicDTO;
	}
}
