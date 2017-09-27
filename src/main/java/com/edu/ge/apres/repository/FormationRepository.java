package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Formation;
import com.edu.ge.apres.domain.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Formation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
