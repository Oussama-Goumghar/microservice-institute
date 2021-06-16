package com.elearning.simplwelearninginstitute.vo.converter;

import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.vo.intern.InstituteVo;
import com.elearning.simplwelearninginstitute.vo.intern.ParcourVo;
import com.elearning.simplwelearninginstitute.vo.intern.ProfVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class ProfConverter extends AbstractConverter<Prof, ProfVo> {
    @Override
    public Prof toItem(ProfVo profVo) {
        if (profVo == null) {
            return null;

        } else {
            Prof prof = new Prof();
            prof.setId(profVo.getId());
            prof.setLogin(profVo.getLogin());
            prof.setPassword(profVo.getPassword());
            prof.setEmail(profVo.getEmail());
            prof.setTelephone(profVo.getTelephone());
            prof.setSex(profVo.getSex());
            prof.setPrenom(profVo.getPrenom());
            prof.setNom(profVo.getNom());
            prof.setInstitute(new InstituteConverter().toItem(profVo.getInstituteVo()));
            prof.setParcour(new ParcourConverter().toItem(profVo.getParcourVo()));
            return prof;
        }
    }

    @Override
    public ProfVo toVo(Prof item) {
        if (item == null) {
            return null;
        } else {
            ProfVo profVo = new ProfVo();
            profVo.setId(item.getId());
            profVo.setLogin(item.getLogin());
            profVo.setPassword(item.getPassword());
            profVo.setEmail(item.getEmail());
            profVo.setTelephone(item.getTelephone());
            profVo.setSex(item.getSex());
            profVo.setPrenom(item.getPrenom());
            profVo.setNom(item.getNom());
            profVo.setInstituteVo(new InstituteConverter().toVo(item.getInstitute()));
            profVo.setParcourVo(new ParcourConverter().toVo(item.getParcour()));

            return profVo;
        }

    }
}
