package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Formule;
import com.edu.ge.apres.domain.Formule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Formule entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FormuleRepository extends JpaRepository<Formule, Long> {

}
