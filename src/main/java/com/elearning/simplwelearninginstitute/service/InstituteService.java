package com.elearning.simplwelearninginstitute.service;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;

import java.util.List;

public interface InstituteService {
     int save(Institute institute);

     int delete(Long id);

     List<Institute> findAll();

    int update(Institute institute, Long id);

     Institute findById(Long id);


}
