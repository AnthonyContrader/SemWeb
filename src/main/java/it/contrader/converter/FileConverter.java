package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.FileDTO;
import it.contrader.model.File;

@Component
public class FileConverter extends AbstractConverter<File, FileDTO>
{
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private TopicConverter topicConverter;

	@Override
	public File toEntity(FileDTO fileDTO) 
	{
		File file = null;
		if(fileDTO != null)
		{
			file = new File();
			file.setId(fileDTO.getId());
			file.setPath(fileDTO.getPath());
			file.setDescription(fileDTO.getDescription());
			file.setType(fileDTO.getType());		
			if(fileDTO.getUserDTO() != null)
				file.setUserId(userConverter.toEntity(fileDTO.getUserDTO()));
			if(fileDTO.getTopicDTO() != null)
				file.setTopicId(topicConverter.toEntity(fileDTO.getTopicDTO()));
		}
		return file;
	}

	@Override
	public FileDTO toDTO(File file) 
	{
		FileDTO fileDTO = null;
		if(file != null)
		{			
			fileDTO = new FileDTO();
			fileDTO.setId(file.getId());
			fileDTO.setPath(file.getPath());
			fileDTO.setDescription(file.getDescription());
			fileDTO.setType(file.getType());
			if(file.getUserId() != null)
				fileDTO.setUserDTO(userConverter.toDTO(file.getUserId()));
			if(file.getTopicId() != null)
				fileDTO.setTopicDTO(topicConverter.toDTO(file.getTopicId()));
		}
		return fileDTO;
	}
}
