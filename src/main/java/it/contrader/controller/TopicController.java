package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.TopicDTO;
import it.contrader.service.TopicService;

@RestController
@RequestMapping("/topic")
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController extends AbstractController<TopicDTO> {
	
	@Autowired
	private TopicService topicService;

}
