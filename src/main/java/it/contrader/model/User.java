package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	public enum Usertype {
		ADMIN,
		USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private Usertype usertype;
	
//	@ManyToMany
//	@JoinTable(name = "tbl_friends", joinColumns = @JoinColumn(name = "personId"),
//		inverseJoinColumns = @JoinColumn(name = "friendId"))
//	private List<User> friends;
//	
//	@ManyToMany
//	@JoinTable(name = "tbl_friends", joinColumns = @JoinColumn(name = "friendId"),
//	 	inverseJoinColumns = @JoinColumn(name = "personId"))
//	private List<User> friendOf;
	
//	@OneToMany(mappedBy = "researcher")
//	private List<Research> researches;
}
