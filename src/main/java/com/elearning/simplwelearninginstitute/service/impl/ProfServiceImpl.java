package com.elearning.simplwelearninginstitute.service.impl;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.repository.ProfDao;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.service.ParcourService;
import com.elearning.simplwelearninginstitute.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfServiceImpl implements ProfService {
    @Autowired
    private ProfDao profDao;
    @Autowired
    private InstituteService instituteService;
    @Autowired
    ParcourService parcourService;


    @Override
    public int save(Prof prof, Long instituteId, Long parcourId) {

        if (profDao.findProfByLogin(prof.getLogin()) != null) {
            return -2;
        } else {
            Institute institute = instituteService.findById(instituteId);
            Parcour parcour = parcourService.findById(parcourId);

            if (institute == null || parcour == null) {
                return -3;
            } else {
                prof.setInstitute(institute);
                prof.setParcour(parcour);
                profDao.save(prof);
                return 1;
            }
        }

    }

    @Override
    public int delete(Long id) {
        Prof prof = findById(id);
        if (prof == null) {
            return -1;
        } else {
            profDao.delete(prof);
            return 1;
        }
    }

    @Override
    public int update(Prof prof, Long id) {
        Prof prof1Existe = findById(id);
        if (prof1Existe != null) {
            if (prof.getLogin() != null) prof1Existe.setLogin(prof.getLogin());
            if (prof.getEmail() != null) prof1Existe.setEmail(prof.getEmail());
            if (prof.getPassword() != null) prof1Existe.setPassword(prof.getPassword());
            if (prof.getTelephone() != null) prof1Existe.setTelephone(prof.getTelephone());
            if (prof.getSex() != null) prof1Existe.setSex(prof.getSex());
            if (prof.getNom() != null) prof1Existe.setNom(prof.getNom());
            if (prof.getPrenom() != null) prof1Existe.setPrenom(prof.getPrenom());
            profDao.save(prof1Existe);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public List<Prof> findAll() {
        return profDao.findAll();
    }

    @Override
    public Prof findById(Long id) {
        if (profDao.findById(id).isPresent()) {
            return profDao.findById(id).get();
        } else {
            return null;
        }

    }
}
