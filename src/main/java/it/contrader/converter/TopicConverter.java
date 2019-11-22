package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TopicDTO;
import it.contrader.model.Topic;

@Component
public class TopicConverter extends AbstractConverter<Topic, TopicDTO> {

	@Override
	public Topic toEntity(TopicDTO dto) {
		Topic t = null;
		if(dto != null)
		{
			ResearchConverter rc = new ResearchConverter();
			
			t = new Topic();
			t.setId(dto.getId());
			t.setKeywords(dto.getKeywords());
			t.setResearched(rc.toEntityList(dto.getResearched()));
		}
		return t;
	}

	@Override
	public TopicDTO toDTO(Topic topic) {
		TopicDTO dto = null;
		if(topic != null)
		{
			ResearchConverter rc = new ResearchConverter();
			
			dto = new TopicDTO();
			dto.setId(topic.getId());
			dto.setKeywords(topic.getKeywords());
			dto.setResearched(rc.toDTOList(topic.getResearched()));
		}
		return dto;
	}
}
