package com.edu.ge.apres.repository;

import com.edu.ge.apres.domain.FormuleVersion;
import com.edu.ge.domain.FormuleVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the FormuleVersion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FormuleVersionRepository extends JpaRepository<FormuleVersion, Long> {

}
