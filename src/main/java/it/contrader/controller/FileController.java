package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.FileDTO;
import it.contrader.service.FileService;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController extends AbstractController<FileDTO> 
{
	@Autowired
	private FileService fileService;
}
