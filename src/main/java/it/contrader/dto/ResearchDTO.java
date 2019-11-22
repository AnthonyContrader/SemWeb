package it.contrader.dto;

import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchDTO {
	
	private Long id;
	
	private Date date;
	
	private UserDTO researcher;
	
	private List<TopicDTO> topics;

}
