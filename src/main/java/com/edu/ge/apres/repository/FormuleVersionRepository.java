package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.FormuleVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Spring Data JPA repository for the FormuleVersion entity.
 */
@SuppressWarnings("unused")
//@RepositoryRestResource
public interface FormuleVersionRepository extends CrudRepository<FormuleVersion, Long> {

}
