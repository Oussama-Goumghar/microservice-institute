package com.elearning.simplwelearninginstitute.service;

import com.elearning.simplwelearninginstitute.entities.EtudiantRequest;
import com.elearning.simplwelearninginstitute.entities.ProfRequeste;

import java.util.List;

public interface ProfRequesteService {

    public int save(ProfRequeste profRequeste, Long instituteId);

    public int delete(Long id);

    int update(ProfRequeste profRequeste, Long id);

    public List<ProfRequeste> findAll();

    public ProfRequeste findById(Long id);
}
