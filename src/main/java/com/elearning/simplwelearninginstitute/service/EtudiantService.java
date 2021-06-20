package com.elearning.simplwelearninginstitute.service;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;

import java.util.List;

public interface EtudiantService {
    public int save(Etudiant etudiant, Long instituteId,Long parcourId);

    public int delete(Long id);

    int update(Etudiant prof, Long id);



    public List<Etudiant> findAll();

    public Etudiant findById(Long id);
    Etudiant findByLogin(String login);

}
