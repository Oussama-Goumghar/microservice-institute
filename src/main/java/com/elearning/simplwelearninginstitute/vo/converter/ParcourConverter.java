package com.elearning.simplwelearninginstitute.vo.converter;

import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.vo.converter.instittueVos.EtudiantInstituteConverter;
import com.elearning.simplwelearninginstitute.vo.converter.instittueVos.ProfInstituteConverter;
import com.elearning.simplwelearninginstitute.vo.intern.ParcourVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import com.elearning.simplwelearninginstitute.vo.utils.DateUtil;
import org.springframework.stereotype.Component;

@Component
public class ParcourConverter extends AbstractConverter<Parcour, ParcourVo> {
    @Override
    public Parcour toItem(ParcourVo parcourVo) {
        if (parcourVo == null) {
            return null;
        } else {
            Parcour parcour = new Parcour();
            parcour.setId(parcourVo.getId());
            parcour.setTitle(parcourVo.getTitle());
            parcour.setDescription(parcourVo.getDescription());
            parcour.setInstitute(new InstituteConverter().toItem(parcourVo.getInstituteVo()));


            return parcour;
        }
    }

    @Override
    public ParcourVo toVo(Parcour item) {
        if (item == null) {
            return null;
        } else {
            ParcourVo parcourVo = new ParcourVo();
            parcourVo.setId(item.getId());
            parcourVo.setTitle(item.getTitle());
           parcourVo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
            parcourVo.setDescription(item.getDescription());
            parcourVo.setInstituteVo(new InstituteConverter().toVo(item.getInstitute()));
            parcourVo.setEtudiantVos(new EtudiantInstituteConverter().toVo(item.getEtudiants()));
            parcourVo.setProfVos(new ProfInstituteConverter().toVo(item.getProfs()));

            return parcourVo;
        }
    }
}
