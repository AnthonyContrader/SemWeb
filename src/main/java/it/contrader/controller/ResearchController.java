package it.contrader.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ResearchDTO;
import it.contrader.dto.TopicDTO;
import it.contrader.service.ResearchService;

@Controller
@RequestMapping("/research")
public class ResearchController {
	
	@Autowired
	private ResearchService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "researches";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "researches";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateresearch";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, 
			@RequestParam("topicname") String topic, @RequestParam("topicid") Long topicId) {
		
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		
		TopicDTO t = new TopicDTO();
		t.setId(topicId);
		t.setKeywords(topic);

		ResearchDTO dto = new ResearchDTO();
		
		dto.setId(id);
		dto.setDate(date);
		dto.setTopic(t);
		service.update(dto);
		setAll(request);
		return "researches";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("topicname") String topic) {
		
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		
		TopicDTO t = new TopicDTO();
		t.setKeywords(topic);		
		ResearchDTO dto = new ResearchDTO();
		dto.setDate(date);
		dto.setTopic(t);
		
		service.insert(dto);
		setAll(request);
		return "researches";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readresearch";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
