package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.EtudiantRequest;
import com.elearning.simplwelearninginstitute.entities.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRequestDao extends JpaRepository<EtudiantRequest,Long> {
    EtudiantRequest findEtudiantRequestByLogin(String login);

    List<EtudiantRequest> findEtudiantRequestByEtatIsTrue();
}
