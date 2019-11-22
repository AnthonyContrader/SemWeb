package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class UserConverter extends AbstractConverter<User,UserDTO> {

	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			
			ResearchConverter rc = new ResearchConverter();
			
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setUsertype(userDTO.getUsertype());			
			
			user.setFriends(this.toEntityList(userDTO.getFriends()));
			user.setFriendOf(this.toEntityList(userDTO.getFriendOf()));
			user.setResearches(rc.toEntityList(userDTO.getResearches()));
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			
			ResearchConverter rc = new ResearchConverter();
						
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setUsertype(user.getUsertype());
			
			userDTO.setFriends(this.toDTOList(user.getFriends()));
			userDTO.setFriendOf(this.toDTOList(user.getFriendOf()));
			userDTO.setResearches(rc.toDTOList(user.getResearches()));
		}
		return userDTO;
	}
}