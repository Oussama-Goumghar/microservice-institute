package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant,Long> {
}
