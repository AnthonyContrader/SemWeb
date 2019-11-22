package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Research;

@Repository
@Transactional
public interface ResearchRepository extends CrudRepository<Research, Long> {

}
