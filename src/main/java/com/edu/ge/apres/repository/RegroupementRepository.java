package com.edu.ge.apres.repository;

import com.edu.ge.domain.Regroupement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Regroupement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegroupementRepository extends JpaRepository<Regroupement, Long> {

}
