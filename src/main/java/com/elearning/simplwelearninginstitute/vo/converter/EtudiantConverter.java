package com.elearning.simplwelearninginstitute.vo.converter;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.vo.intern.EtudiantVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class EtudiantConverter extends AbstractConverter<Etudiant, EtudiantVo> {
    @Override
    public Etudiant toItem(EtudiantVo etudiantVo) {
        if (etudiantVo == null) {
            return null;
        } else {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(etudiantVo.getId());
            etudiant.setTelephone(etudiantVo.getTelephone());
            etudiant.setNom(etudiantVo.getNom());
            etudiant.setPrenom(etudiantVo.getPrenom());
            etudiant.setEmail(etudiantVo.getEmail());
            etudiant.setLogin(etudiantVo.getLogin());
            etudiant.setPassword(etudiantVo.getPassword());
            etudiant.setSex(etudiantVo.getSex());
            etudiant.setInstitute(new InstituteConverter().toItem(etudiantVo.getInstituteVo()));
            etudiant.setParcour(new ParcourConverter().toItem(etudiantVo.getParcourVo()));
            return etudiant;
        }
    }

    @Override
    public EtudiantVo toVo(Etudiant item) {
        if (item == null) {
            return null;
        } else {
            EtudiantVo etudiantVo = new EtudiantVo();
            etudiantVo.setId(item.getId());
            etudiantVo.setTelephone(item.getTelephone());
            etudiantVo.setNom(item.getNom());
            etudiantVo.setPrenom(item.getPrenom());
            etudiantVo.setEmail(item.getEmail());
            etudiantVo.setLogin(item.getLogin());
            etudiantVo.setPassword(item.getPassword());
            etudiantVo.setSex(item.getSex());
            etudiantVo.setInstituteVo(new InstituteConverter().toVo(item.getInstitute()));
            etudiantVo.setParcourVo(new ParcourConverter().toVo(item.getParcour()));
            return etudiantVo;
        }
    }
}
