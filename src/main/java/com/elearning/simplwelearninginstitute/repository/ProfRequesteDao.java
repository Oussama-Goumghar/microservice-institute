package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.ProfRequeste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfRequesteDao extends JpaRepository<ProfRequeste,Long> {

}
