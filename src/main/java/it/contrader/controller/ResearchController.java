package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ResearchDTO;
import it.contrader.service.ResearchService;

@RestController
@RequestMapping("/research")
@CrossOrigin(origins = "http://localhost:4200")
public class ResearchController extends AbstractController<ResearchDTO> {
	
	@Autowired
	private ResearchService researchService;

}
