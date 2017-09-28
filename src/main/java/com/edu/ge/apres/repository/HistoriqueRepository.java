package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Historique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data JPA repository for the Historique entity.
 */
@SuppressWarnings("unused")
//@RepositoryRestResource
public interface HistoriqueRepository extends CrudRepository<Historique, Long> {

}
