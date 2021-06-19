package com.elearning.simplwelearninginstitute.vo.converter.instittueVos;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.vo.converter.InstituteConverter;
import com.elearning.simplwelearninginstitute.vo.converter.ParcourConverter;
import com.elearning.simplwelearninginstitute.vo.intern.EtudiantVo;
import com.elearning.simplwelearninginstitute.vo.intern.institute.EtudiantInstituteVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;

public class EtudiantInstituteConverter extends AbstractConverter<Etudiant, EtudiantInstituteVo> {
    @Override
    public Etudiant toItem(EtudiantInstituteVo etudiantInstituteVo) {
        return null;
    }

    @Override
    public EtudiantInstituteVo toVo(Etudiant item) {
        if (item == null) {
            return null;
        } else {
            EtudiantInstituteVo etudiantVo = new EtudiantInstituteVo();
            etudiantVo.setId(item.getId());
            etudiantVo.setTelephone(item.getTelephone());
            etudiantVo.setNom(item.getNom());
            etudiantVo.setPrenom(item.getPrenom());
            etudiantVo.setEmail(item.getEmail());
            etudiantVo.setLogin(item.getLogin());
            etudiantVo.setPassword(item.getPassword());
            etudiantVo.setSex(item.getSex());
            return etudiantVo;
        }
    }
}
