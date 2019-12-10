package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.File;

@Repository
@Transactional
public interface FileRepository extends CrudRepository<File, Long> {

}
