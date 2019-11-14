package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.TopicConverter;
import it.contrader.dao.TopicRepository;
import it.contrader.dto.TopicDTO;
import it.contrader.model.Topic;

@Service
public class TopicService extends AbstractService<Topic, TopicDTO> {
	
	@Autowired
	private TopicConverter converter;
	
	@Autowired
	private TopicRepository repository;
	
	public TopicDTO findByKeywords(String keywords) {
		return converter.toDTO(repository.findByKeywords(keywords));
	}
}
