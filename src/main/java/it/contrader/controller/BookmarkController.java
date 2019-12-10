package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.service.BookmarkService;

@RestController
@RequestMapping("/bookmark")
@CrossOrigin(origins = "http://localhost:4200")
public class BookmarkController {

	@Autowired BookmarkService bookmarkService;
	
}
