package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.MatriceTypeFormation;
import com.edu.ge.domain.MatriceTypeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the MatriceTypeFormation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MatriceTypeFormationRepository extends JpaRepository<MatriceTypeFormation, Long> {

}
