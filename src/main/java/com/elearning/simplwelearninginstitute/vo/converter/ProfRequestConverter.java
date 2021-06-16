package com.elearning.simplwelearninginstitute.vo.converter;

import com.elearning.simplwelearninginstitute.entities.ProfRequeste;
import com.elearning.simplwelearninginstitute.vo.intern.ProfRequestVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class ProfRequestConverter extends AbstractConverter<ProfRequeste, ProfRequestVo> {

    @Override
    public ProfRequeste toItem(ProfRequestVo profRequestVo) {
        if (profRequestVo == null) {
            return null;
        } else {
            ProfRequeste profRequeste = new ProfRequeste();
            profRequeste.setId(profRequestVo.getId());
            profRequeste.setLogin(profRequestVo.getLogin());
            profRequeste.setPassword(profRequestVo.getPassword());
            profRequeste.setEmail(profRequestVo.getEmail());
            profRequeste.setTelephone(profRequestVo.getTelephone());
            profRequeste.setSex(profRequestVo.getSex());
            profRequeste.setCv(profRequestVo.getCv());
            profRequeste.setPrenom(profRequestVo.getPrenom());
            profRequeste.setNom(profRequestVo.getNom());
            profRequeste.setEtat(profRequestVo.isEtat());
            profRequeste.setInstitute(new InstituteConverter().toItem(profRequestVo.getInstituteVo()));
            profRequeste.setParcour(new ParcourConverter().toItem(profRequestVo.getParcourVo()));

            return profRequeste;
        }
    }

    @Override
    public ProfRequestVo toVo(ProfRequeste item) {
        if (item == null) {
            return null;
        } else {
            ProfRequestVo profRequestVo = new ProfRequestVo();
            profRequestVo.setId(item.getId());
            profRequestVo.setLogin(item.getLogin());
            profRequestVo.setPassword(item.getPassword());
            profRequestVo.setEmail(item.getEmail());
            profRequestVo.setTelephone(item.getTelephone());
            profRequestVo.setSex(item.getSex());
            profRequestVo.setCv(item.getCv());
            profRequestVo.setPrenom(item.getPrenom());
            profRequestVo.setNom(item.getNom());
            profRequestVo.setEtat(item.isEtat());
            profRequestVo.setInstituteVo(new InstituteConverter().toVo(item.getInstitute()));
            profRequestVo.setParcourVo(new ParcourConverter().toVo(item.getParcour()));

            return profRequestVo;
        }
    }
}
