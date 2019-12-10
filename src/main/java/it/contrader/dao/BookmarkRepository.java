package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Bookmark;

@Repository
@Transactional
public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {

}
