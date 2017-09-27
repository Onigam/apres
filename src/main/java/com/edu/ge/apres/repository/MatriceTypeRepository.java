package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.MatriceType;
import com.edu.ge.domain.MatriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the MatriceType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MatriceTypeRepository extends JpaRepository<MatriceType, Long> {

}
