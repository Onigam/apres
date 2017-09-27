package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Historique;
import com.edu.ge.apres.domain.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Historique entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {

}
