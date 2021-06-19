package com.elearning.simplwelearninginstitute.vo.converter;

import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.vo.converter.instittueVos.EtudiantInstituteConverter;
import com.elearning.simplwelearninginstitute.vo.converter.instittueVos.ParcourInstituteConverter;
import com.elearning.simplwelearninginstitute.vo.converter.instittueVos.ProfInstituteConverter;
import com.elearning.simplwelearninginstitute.vo.intern.institute.InstituteVo;
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
            instituteVo.setEtudiantVos(new EtudiantInstituteConverter().toVo(item.getEtudiants()));
            instituteVo.setProfVos(new ProfInstituteConverter().toVo(item.getProfs()));
            instituteVo.setParcourVos(new ParcourInstituteConverter().toVo(item.getParcours()));

            return instituteVo;
        }
    }
}
