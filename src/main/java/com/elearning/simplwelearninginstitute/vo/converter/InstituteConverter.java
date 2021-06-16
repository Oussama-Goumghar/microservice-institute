package com.elearning.simplwelearninginstitute.vo.converter;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.vo.intern.InstituteVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class InstituteConverter extends AbstractConverter<Institute, InstituteVo> {
    @Override
    public Institute toItem(InstituteVo instituteVo) {
        if (instituteVo == null) {
            return null;
        } else {
            Institute institute = new Institute();
            institute.setId(instituteVo.getId());
            institute.setTitle(instituteVo.getTitle());
            institute.setTelephone(instituteVo.getTelephone());
            institute.setLogin(instituteVo.getLogin());
            institute.setEmail(instituteVo.getEmail());
            institute.setPassword(instituteVo.getPassword());
            institute.setEtudiants(new EtudiantConverter().toItem(instituteVo.getEtudiantVos()));
            institute.setProfs(new ProfConverter().toItem(instituteVo.getProfVos()));
            institute.setParcours(new ParcourConverter().toItem(instituteVo.getParcourVos()));
            return institute;
        }
    }

    @Override
    public InstituteVo toVo(Institute item) {
        if (item == null) {
            return null;
        } else {
            InstituteVo instituteVo = new InstituteVo();
            instituteVo.setId(item.getId());
            instituteVo.setTitle(item.getTitle());
            instituteVo.setTelephone(item.getTelephone());
            instituteVo.setLogin(item.getLogin());
            instituteVo.setEmail(item.getEmail());
            instituteVo.setPassword(item.getPassword());
            instituteVo.setEtudiantVos(new EtudiantConverter().toVo(item.getEtudiants()));
            instituteVo.setProfVos(new ProfConverter().toVo(item.getProfs()));
            instituteVo.setParcourVos(new ParcourConverter().toVo(item.getParcours()));

            return instituteVo;
        }
    }
}
