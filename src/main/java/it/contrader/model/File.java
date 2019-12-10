package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String path;
	
	private String description;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "idTopic", referencedColumnName = "id")
	private Topic topicId;
}
