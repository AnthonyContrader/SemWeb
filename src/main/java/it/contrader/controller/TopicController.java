package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TopicDTO;
import it.contrader.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	private TopicService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "topics";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "topics";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetopic";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, 
			@RequestParam("keywords") String keywords) {

		TopicDTO dto = new TopicDTO();
		dto.setId(id);
		dto.setKeywords(keywords);
		service.update(dto);
		setAll(request);
		return "topics";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("keywords") String keywords) {
		TopicDTO dto = new TopicDTO();
		dto.setKeywords(keywords);
		service.insert(dto);
		setAll(request);
		return "topics";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtopic";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
