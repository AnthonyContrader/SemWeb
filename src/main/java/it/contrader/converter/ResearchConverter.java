package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.ResearchDTO;
import it.contrader.model.Research;

@Component
public class ResearchConverter extends AbstractConverter<Research, ResearchDTO> {

	@Override
	public Research toEntity(ResearchDTO dto) {
		Research r = null;
		if(dto != null) 
		{
			UserConverter uc = new UserConverter();
			TopicConverter tc = new TopicConverter();
			
			r = new Research();
			r.setId(dto.getId());
			r.setDate(dto.getDate());
			r.setResearcher(uc.toEntity(dto.getResearcher()));
			r.setTopics(tc.toEntityList(dto.getTopics()));
						
		}
		return r;
	}

	@Override
	public ResearchDTO toDTO(Research research) {
		ResearchDTO dto = null;
		if(research != null)
		{
			UserConverter uc = new UserConverter();
			TopicConverter tc = new TopicConverter();
			
			dto = new ResearchDTO();
			dto.setId(research.getId());
			dto.setDate(research.getDate());
			dto.setResearcher(uc.toDTO(research.getResearcher()));
			dto.setTopics(tc.toDTOList(research.getTopics()));
			
		}
		return dto;
	}
}
