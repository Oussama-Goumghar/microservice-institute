package com.elearning.simplwelearninginstitute.service;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.EtudiantRequest;

import java.util.List;

public interface EtudiantRequestService {

    public int save(EtudiantRequest etudiantRequest, Long instituteId);

    public int delete(Long id);

    int update(EtudiantRequest etudiantRequest, Long id);

    int aprouveRequest(Long id);

     List<EtudiantRequest> findAll();

     EtudiantRequest findById(Long id);

    List<EtudiantRequest> findEtudiantRequesteApproved();

    int saveEtudianteApproved(Long id);


}
