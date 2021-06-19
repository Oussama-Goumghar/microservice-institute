package com.elearning.simplwelearninginstitute.vo.converter.instittueVos;

import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.vo.intern.ProfVo;
import com.elearning.simplwelearninginstitute.vo.intern.institute.ProfInstituteVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;

public class ProfInstituteConverter extends AbstractConverter<Prof, ProfInstituteVo> {

    @Override
    public Prof toItem(ProfInstituteVo profInstituteVo) {
        return null;
    }

    @Override
    public ProfInstituteVo toVo(Prof item) {
        if (item == null) {
            return null;
        } else {
            ProfInstituteVo profVo = new ProfInstituteVo();
            profVo.setId(item.getId());
            profVo.setLogin(item.getLogin());
            profVo.setPassword(item.getPassword());
            profVo.setEmail(item.getEmail());
            profVo.setTelephone(item.getTelephone());
            profVo.setSex(item.getSex());
            profVo.setPrenom(item.getPrenom());
            profVo.setNom(item.getNom());

            return profVo;
        }

    }
}
