package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Etude;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring Data JPA repository for the Etude entity.
 */
@SuppressWarnings("unused")
//@RepositoryRestResource
public interface EtudeRepository extends CrudRepository<Etude, Long> {

}
