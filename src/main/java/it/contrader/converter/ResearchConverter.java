package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ResearchDTO;
import it.contrader.model.Research;

@Component
public class ResearchConverter extends AbstractConverter<Research, ResearchDTO> {

	@Override
	public Research toEntity(ResearchDTO dto) {
		
		TopicConverter tc = new TopicConverter();
		
		Research r = null;
		if(dto != null) {
			r = new Research(dto.getId(), dto.getDate(), tc.toEntity(dto.getTopic()));
		}
		return r;
	}

	@Override
	public ResearchDTO toDTO(Research r) {
		
		TopicConverter tc = new TopicConverter();
		
		ResearchDTO dto = null;
		if(r != null) {
			dto = new ResearchDTO(r.getId(), r.getDate(), tc.toDTO(r.getTopic()));
		}
		return dto;
	}
}
