package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Topic;

@Repository
@Transactional
public interface TopicRepository extends CrudRepository<Topic, Long> {
	
	Topic findByKeywords(String keywords);

}
