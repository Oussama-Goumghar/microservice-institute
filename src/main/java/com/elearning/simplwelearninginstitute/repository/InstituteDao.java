package com.elearning.simplwelearninginstitute.repository;

import com.elearning.simplwelearninginstitute.entities.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteDao extends JpaRepository<Institute,Long> {

     Institute findInstituteByLogin(String login);
}
