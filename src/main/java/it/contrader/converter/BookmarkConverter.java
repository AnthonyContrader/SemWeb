package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.BookmarkDTO;
import it.contrader.model.Bookmark;

@Component
public class BookmarkConverter  extends AbstractConverter<Bookmark, BookmarkDTO>{
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private TopicConverter topicConverter;
	
	
	
	@Override
	public Bookmark toEntity(BookmarkDTO bookmarkDTO) {
		Bookmark bookmark=null;
		if(bookmarkDTO != null) {
			bookmark = new Bookmark();
			bookmark.setId(bookmarkDTO.getId());
			bookmark.setBookmarkName(bookmarkDTO.getBookmarkName());
			if(bookmarkDTO.getUserDTO() != null) {
				bookmark.setUser(userConverter.toEntity(bookmarkDTO.getUserDTO()));
			}
			if (bookmarkDTO.getTopicDTO() != null){
				bookmark.setTopic(topicConverter.toEntity(bookmarkDTO.getTopicDTO()));
			}
		}
		
		return bookmark;
	}

	@Override
	public BookmarkDTO toDTO(Bookmark bookmark) {
		 BookmarkDTO bookmarkDTO=null;
		 if(bookmark != null) {
			 bookmarkDTO =new BookmarkDTO();
			 bookmarkDTO.setId(bookmark.getId());
			 bookmarkDTO.setBookmarkName(bookmark.getBookmarkName());
			 if(bookmark.getUser() != null) {
				 bookmarkDTO.setUserDTO(userConverter.toDTO(bookmark.getUser()));
			 }
			 
			 if(bookmark.getTopic() != null) {
				 bookmarkDTO.setTopicDTO(topicConverter.toDTO(bookmark.getTopic()));
				 
			 }
		 }
		 
		return bookmarkDTO;
	}
	
}
