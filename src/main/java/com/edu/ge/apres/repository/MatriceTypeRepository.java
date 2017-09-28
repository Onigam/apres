package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.MatriceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data JPA repository for the MatriceType entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface MatriceTypeRepository extends CrudRepository<MatriceType, Long> {

}
