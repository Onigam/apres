package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.MatriceTypeFormation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data JPA repository for the MatriceTypeFormation entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface MatriceTypeFormationRepository extends CrudRepository<MatriceTypeFormation, Long> {

}
