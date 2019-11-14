package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ResearchConverter;
import it.contrader.dao.ResearchRepository;
import it.contrader.dto.ResearchDTO;
import it.contrader.model.Research;
import it.contrader.model.Topic;

@Service
public class ResearchService extends AbstractService<Research, ResearchDTO> {
	
	@Autowired
	private ResearchConverter converter;
	
	@Autowired
	private ResearchRepository repository;
	
	public ResearchDTO findByTopic(Topic t) {
		return converter.toDTO(repository.findByTopic(t));
	}
	

}
