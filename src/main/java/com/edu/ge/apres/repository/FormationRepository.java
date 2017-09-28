package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Formation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data JPA repository for the Formation entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface FormationRepository extends CrudRepository<Formation, Long> {

}
