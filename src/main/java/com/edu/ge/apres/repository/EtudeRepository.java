package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.Etude;
import com.edu.ge.apres.domain.Etude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Etude entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EtudeRepository extends JpaRepository<Etude, Long> {

}
