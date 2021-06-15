package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.EtudiantRequest;
import com.elearning.simplwelearninginstitute.entities.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRequestDao extends JpaRepository<EtudiantRequest,Long> {
}
