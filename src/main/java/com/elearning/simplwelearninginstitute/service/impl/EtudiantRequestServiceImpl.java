package com.elearning.simplwelearninginstitute.service.impl;

import com.elearning.simplwelearninginstitute.entities.*;
import com.elearning.simplwelearninginstitute.repository.EtudiantRequestDao;
import com.elearning.simplwelearninginstitute.repository.ProfRequesteDao;
import com.elearning.simplwelearninginstitute.service.EtudiantRequestService;
import com.elearning.simplwelearninginstitute.service.EtudiantService;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantRequestServiceImpl implements EtudiantRequestService {
    @Autowired
    EtudiantRequestDao etudiantRequestDao;
    @Autowired
    InstituteService instituteService;
    @Autowired
    EtudiantService etudiantService;


    @Override
    public int save(EtudiantRequest etudiantRequest, Long instituteId) {
        if (etudiantRequestDao.findEtudiantRequestByLogin(etudiantRequest.getLogin()) != null) {
            return -2;
        } else {
            Institute institute = instituteService.findById(instituteId);
            if ( institute== null) {
                return -3;
            } else {
                etudiantRequest.setInstitute(institute);
                etudiantRequest.setEtat(false);
                etudiantRequestDao.save(etudiantRequest);
                return 1;
            }
        }
    }

    @Override
    public int delete(Long id) {
        EtudiantRequest etudiantRequest = findById(id);
        if (etudiantRequest == null) {
            return -1;
        } else {
            etudiantRequestDao.delete(etudiantRequest);
            return 1;
        }
    }

    @Override
    public int update(EtudiantRequest etudiantRequest, Long id) {
        return 0;
    }

    @Override
    public int aprouveRequest(Long id) {
        EtudiantRequest etudiantRequest = findById(id);
        if (etudiantRequest == null) {
            return -1;
        } else {
            etudiantRequest.setEtat(true);
            etudiantRequestDao.save(etudiantRequest);
            return 1;
        }
    }

    @Override
    public List<EtudiantRequest> findAll() {
        return etudiantRequestDao.findAll();
    }

    @Override
    public EtudiantRequest findById(Long id) {
        if (etudiantRequestDao.findById(id).isPresent()) {
            return etudiantRequestDao.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<EtudiantRequest> findEtudiantRequesteApproved() {
        return etudiantRequestDao.findEtudiantRequestByEtatIsTrue();
    }

    @Override
    public int saveEtudianteApproved(Long id) {
        EtudiantRequest etudiantRequest=findById(id);

        if (etudiantRequest == null) {
            return -1;
        } else {
            if (!etudiantRequest.isEtat()) {
                return -4;
            } else {
                Etudiant etudiant = new Etudiant();
                etudiant.setLogin(etudiantRequest.getLogin());
                etudiant.setPassword(etudiantRequest.getPassword());
                etudiant.setEmail(etudiantRequest.getEmail());
                etudiant.setTelephone(etudiantRequest.getTelephone());
                etudiant.setSex(etudiantRequest.getSex());
                etudiant.setNom(etudiantRequest.getNom());
                etudiant.setPrenom(etudiantRequest.getPrenom());
                etudiant.setDateNaissance(etudiantRequest.getDateNaissance());

                int res=  etudiantService.save(etudiant,etudiantRequest.getInstitute().getId());
                if (res == 1) {
                    etudiantRequestDao.delete(etudiantRequest);
                }
                return res;
            }
        }
    }
}
