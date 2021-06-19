package com.elearning.simplwelearninginstitute.vo.converter;

import com.elearning.simplwelearninginstitute.entities.EtudiantRequest;
import com.elearning.simplwelearninginstitute.vo.intern.EtudiantReauestVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class EtudiantRequestConverter extends AbstractConverter<EtudiantRequest, EtudiantReauestVo> {
    @Override
    public EtudiantRequest toItem(EtudiantReauestVo etudiantReauestVo) {
        if (etudiantReauestVo == null) {
            return null;
        } else {
            EtudiantRequest etudiantRequest = new EtudiantRequest();
            etudiantRequest.setId(etudiantReauestVo.getId());
            etudiantRequest.setTelephone(etudiantReauestVo.getTelephone());
            etudiantRequest.setNom(etudiantReauestVo.getNom());
            etudiantRequest.setPrenom(etudiantReauestVo.getPrenom());
            etudiantRequest.setEmail(etudiantReauestVo.getEmail());
            etudiantRequest.setLogin(etudiantReauestVo.getLogin());
            etudiantRequest.setPassword(etudiantReauestVo.getPassword());
            etudiantRequest.setSex(etudiantReauestVo.getSex());
            etudiantRequest.setCv(etudiantReauestVo.getCv());
            etudiantRequest.setEtat(etudiantReauestVo.isEtat());
            etudiantRequest.setParcour(new ParcourConverter().toItem(etudiantReauestVo.getParcourVo()));
            etudiantRequest.setInstitute(new InstituteConverter().toItem(etudiantReauestVo.getInstituteVo()));

            return etudiantRequest;
        }
    }

    @Override
    public EtudiantReauestVo toVo(EtudiantRequest item) {
        if (item == null) {
            return null;
        } else {
            EtudiantReauestVo etudiantReauestVo = new EtudiantReauestVo();
            etudiantReauestVo.setId(item.getId());
            etudiantReauestVo.setTelephone(item.getTelephone());
            etudiantReauestVo.setNom(item.getNom());
            etudiantReauestVo.setPrenom(item.getPrenom());
            etudiantReauestVo.setEmail(item.getEmail());
            etudiantReauestVo.setLogin(item.getLogin());
            etudiantReauestVo.setPassword(item.getPassword());
            etudiantReauestVo.setSex(item.getSex());
            etudiantReauestVo.setCv(item.getCv());
            etudiantReauestVo.setEtat(item.isEtat());
            etudiantReauestVo.setParcourVo(new ParcourConverter().toVo(item.getParcour()));
            etudiantReauestVo.setInstituteVo(new InstituteConverter().toVo(item.getInstitute()));

            return etudiantReauestVo;
        }
    }
}
