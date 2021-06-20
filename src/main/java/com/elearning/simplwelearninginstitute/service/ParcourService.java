package com.elearning.simplwelearninginstitute.service;

import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.entities.Prof;

import java.util.List;

public interface ParcourService {
    public int save(Parcour parcour, Long instituteId);

    public int delete(Long id);

    int update(Parcour parcour, Long id);

    public List<Parcour> findAll();

    public Parcour findById(Long id);

    public List<Parcour> findByInstitute(Long id);
}
