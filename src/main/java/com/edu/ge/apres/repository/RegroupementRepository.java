package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Regroupement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data JPA repository for the Regroupement entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface RegroupementRepository extends CrudRepository<Regroupement, Long> {
}
