package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.EtudeFormuleFormation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the EtudeFormuleFormation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EtudeFormuleFormationRepository extends CrudRepository<EtudeFormuleFormation, Long> {

}
