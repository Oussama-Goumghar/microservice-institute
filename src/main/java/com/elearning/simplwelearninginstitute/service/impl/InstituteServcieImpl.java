package com.elearning.simplwelearninginstitute.service.impl;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.repository.InstituteDao;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServcieImpl implements InstituteService {

    @Autowired
    private InstituteDao instituteDao;


    @Override
    public int save(Institute institute) {
        Institute instituteExist = instituteDao.findInstituteByLogin(institute.getLogin());
        if (instituteExist != null) {
            return -2;
        } else if (institute == null) {
            return -1;
        } else {
            instituteDao.save(institute);
            return 1;
        }
    }

    @Override
    public int delete(Long id) {
        Institute institute = findById(id);
        if (institute == null) {
            return -1;
        } else {
            instituteDao.delete(institute);
            return 1;
        }
    }

    @Override
    public List<Institute> findAll() {
        return instituteDao.findAll();
    }

    @Override
    public int update(Institute institute, Long id) {
        Institute instituteExiste = findById(id);

        if (instituteExiste != null) {
            if (institute.getEmail() != null) instituteExiste.setEmail(institute.getEmail());
            if (institute.getLogin() != null) instituteExiste.setLogin(institute.getLogin());
            if (institute.getPassword() != null) instituteExiste.setPassword(institute.getPassword());
            if (institute.getTelephone() != null) instituteExiste.setTelephone(institute.getTelephone());
            if (institute.getTitle() != null) instituteExiste.setTitle(institute.getTitle());

            instituteDao.save(instituteExiste);
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public Institute findById(Long id) {
        if (instituteDao.findById(id).isPresent()) {
            return instituteDao.findById(id).get();
        } else {
            return null;
        }

    }
}
