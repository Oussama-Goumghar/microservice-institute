package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Parcour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcourDao extends JpaRepository<Parcour,Long> {
    Parcour findParcourByTitle(String title);

    List<Parcour> findParcourByInstituteId(Long id);

}
