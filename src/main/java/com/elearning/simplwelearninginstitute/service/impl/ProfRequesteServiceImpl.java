package com.elearning.simplwelearninginstitute.service.impl;


import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.entities.ProfRequeste;
import com.elearning.simplwelearninginstitute.repository.ProfRequesteDao;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.service.ProfRequesteService;
import com.elearning.simplwelearninginstitute.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfRequesteServiceImpl implements ProfRequesteService {

    @Autowired
    ProfRequesteDao profRequesteDao;
    @Autowired
    InstituteService instituteService;
    @Autowired
    ProfService profService;


    @Override
    public int save(ProfRequeste profRequeste, Long instituteId) {
        if (profRequesteDao.findProfRequestesByLogin(profRequeste.getLogin()) != null) {
            return -2;
        } else {
            Institute institute = instituteService.findById(instituteId);
            if ( institute== null) {
                return -3;
            } else {
                profRequeste.setInstitute(institute);
                profRequeste.setEtat(false);
                profRequesteDao.save(profRequeste);
                return 1;
            }
        }
    }

    @Override
    public int delete(Long id) {
        ProfRequeste profRequeste = findById(id);
        if (profRequeste == null) {
            return -1;
        } else {
            profRequesteDao.delete(profRequeste);
            return 1;
        }
    }

    @Override
    public int update(ProfRequeste profRequeste, Long id) {
        return 0;
    }

    @Override
    public int aprouveRequest(Long id) {
        ProfRequeste profRequeste = findById(id);
        if (profRequeste == null) {
            return -1;
        } else {
            profRequeste.setEtat(true);
            profRequesteDao.save(profRequeste);
            return 1;
        }
    }

    @Override
    public List<ProfRequeste> findAll() {
        return profRequesteDao.findAll();
    }

    @Override
    public ProfRequeste findById(Long id) {
        if (profRequesteDao.findById(id).isPresent()) {
            return profRequesteDao.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<ProfRequeste> findProfRequestApproved() {
        return profRequesteDao.findProfRequesteByEtatIsTrue();
    }

    @Override
    public ProfRequeste findProfRequestApprovedById(Long id) {
        return profRequesteDao.findProfRequesteByIdAndEtatIsTrue(id);
    }

    @Override
    public int saveProfAapproved(Long id) {
        ProfRequeste profRequeste=findById(id);

        if (profRequeste == null) {
            return -1;
        } else {
            if (!profRequeste.isEtat()) {
                return -4;
            } else {
                Prof prof = new Prof();
                prof.setLogin(profRequeste.getLogin());
                prof.setPassword(profRequeste.getPassword());
                prof.setEmail(profRequeste.getEmail());
                prof.setTelephone(profRequeste.getTelephone());
                prof.setSex(profRequeste.getSex());

                int res=  profService.save(prof,profRequeste.getInstitute().getId());
                if (res == 1) {
                    profRequesteDao.delete(profRequeste);
                }
                return res;
            }
        }

    }
}
