package com.elearning.simplwelearninginstitute.service.impl;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.repository.ParcourDao;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.service.ParcourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ParcourServiceImpl implements ParcourService {

    @Autowired
    ParcourDao parcourDao;
    @Autowired
    InstituteService instituteService;

    @Override
    public int save(Parcour parcour, Long instituteId) {
        if (parcourDao.findParcourByTitle(parcour.getTitle()) != null) {
            return -2;
        } else {
            Institute institute = instituteService.findById(instituteId);
            if ( institute== null) {
                return -3;
            } else {
                parcour.setInstitute(institute);
                parcour.setDateCreation(new Date());
                parcourDao.save(parcour);
                return 1;
            }
        }
    }

    @Override
    public int delete(Long id) {
        Parcour parcour = findById(id);
        if (parcour == null) {
            return -1;
        } else {
            parcourDao.delete(parcour);
            return 1;
        }
    }

    @Override
    public int update(Parcour parcour, Long id) {
        Parcour parcouExist = findById(id);
        if (parcouExist != null) {
            if (parcour.getTitle() != null) parcouExist.setTitle(parcour.getTitle());
            if (parcour.getDescription() != null) parcouExist.setDescription(parcour.getDescription());
            if (parcour.getDateCreation() != null) parcouExist.setDateCreation(parcour.getDateCreation());

            parcourDao.save(parcouExist);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public List<Parcour> findAll() {
        return parcourDao.findAll();
    }

    @Override
    public Parcour findById(Long id) {
        if (parcourDao.findById(id).isPresent()) {
            return parcourDao.findById(id).get();
        } else {
            return null;
        }
    }
}
