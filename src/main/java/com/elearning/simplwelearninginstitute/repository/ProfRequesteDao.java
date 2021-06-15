package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.ProfRequeste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfRequesteDao extends JpaRepository<ProfRequeste,Long> {

    ProfRequeste findProfRequestesByLogin(String login);
    List<ProfRequeste> findProfRequesteByEtatIsTrue();
    ProfRequeste findProfRequesteByIdAndEtatIsTrue(Long id);
}
