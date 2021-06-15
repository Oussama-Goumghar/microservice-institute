package com.elearning.simplwelearninginstitute.service;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.EtudiantRequest;

import java.util.List;

public interface EtudiantRequestService {

    public int save(EtudiantRequest etudiantRequest, Long instituteId);

    public int delete(Long id);

    int update(EtudiantRequest etudiantRequest, Long id);

    public List<EtudiantRequest> findAll();

    public EtudiantRequest findById(Long id);
}
