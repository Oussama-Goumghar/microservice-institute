package com.elearning.simplwelearninginstitute.service.impl;


import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.repository.EtudiantDao;
import com.elearning.simplwelearninginstitute.service.EtudiantService;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDao etudiantDao;
    @Autowired
    private InstituteService instituteService;

    @Override
    public int save(Etudiant etudiant, Long instituteId) {
        if (etudiantDao.findEtudiantByLogin(etudiant.getLogin()) != null) {
            return -2;
        } else {
            Institute institute = instituteService.findById(instituteId);
            if ( institute== null) {
                return -3;
            } else {
                etudiant.setInstitute(institute);
                etudiantDao.save(etudiant);
                return 1;
            }
        }

    }

    @Override
    public int delete(Long id) {
        Etudiant etudiant = findById(id);
        if (etudiant == null) {
            return -1;
        } else {
            etudiantDao.delete(etudiant);
            return 1;
        }
    }

    @Override
    public int update(Etudiant etudiant, Long id) {
        Etudiant etudiantExiste = findById(id);
        if (etudiantExiste != null) {
            if (etudiant.getLogin() != null) etudiantExiste.setLogin(etudiant.getLogin());
            if (etudiant.getEmail() != null) etudiantExiste.setEmail(etudiant.getEmail());
            if (etudiant.getPassword() != null) etudiantExiste.setPassword(etudiant.getPassword());
            if (etudiant.getTelephone() != null) etudiantExiste.setTelephone(etudiant.getTelephone());
            if (etudiant.getSex() != null) etudiantExiste.setSex(etudiant.getSex());
            if (etudiant.getDateNaissance() != null) etudiantExiste.setDateNaissance(etudiant.getDateNaissance());
            etudiantDao.save(etudiantExiste);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantDao.findAll();
    }

    @Override
    public Etudiant findById(Long id) {
        if (etudiantDao.findById(id).isPresent()) {
            return etudiantDao.findById(id).get();
        } else {
            return null;
        }
    }
}
