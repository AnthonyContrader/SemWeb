package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.ResearchDTO;
import it.contrader.model.Research;

@Component
public class ResearchConverter extends AbstractConverter<Research, ResearchDTO> {
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private TopicConverter topicConverter;

	@Override
	public Research toEntity(ResearchDTO researchDTO) {
		Research research = null;
		if(researchDTO != null) 
		{			
			research = new Research();
			research.setId(researchDTO.getId());
			research.setDate(researchDTO.getDate());
			if(researchDTO.getUserDTO() != null)
				research.setUserId(userConverter.toEntity(researchDTO.getUserDTO()));
			if(researchDTO.getTopicDTO() != null) 
				research.setTopicId(topicConverter.toEntity(researchDTO.getTopicDTO()));						
		}
		return research;
	}

	@Override
	public ResearchDTO toDTO(Research research) {
		ResearchDTO researchDTO = null;
		if(research != null)
		{
			researchDTO = new ResearchDTO();
			researchDTO.setId(research.getId());
			researchDTO.setDate(research.getDate());
			if(research.getUserId() != null)
				researchDTO.setUserDTO(userConverter.toDTO(research.getUserId()));
			if(research.getTopicId() != null)
				researchDTO.setTopicDTO(topicConverter.toDTO(research.getTopicId()));
		}
		return researchDTO;
	}
}
