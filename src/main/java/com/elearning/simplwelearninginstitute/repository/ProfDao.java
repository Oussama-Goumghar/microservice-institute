package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.Prof;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfDao extends JpaRepository<Prof,Long> {
    Prof findProfByLogin(String login);
}
