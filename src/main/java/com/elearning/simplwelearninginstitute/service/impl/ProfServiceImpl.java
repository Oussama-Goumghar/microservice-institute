package com.elearning.simplwelearninginstitute.service.impl;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.repository.ProfDao;
import com.elearning.simplwelearninginstitute.service.InstituteService;
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


    @Override
    public int save(Prof prof, Long instituteId) {

            if (profDao.findProfByLogin(prof.getLogin()) != null) {
                return -2;
            } else {
                Institute institute = instituteService.findById(instituteId);
                if ( institute== null) {
                    return -3;
                } else {
                    prof.setInstitute(institute);
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
