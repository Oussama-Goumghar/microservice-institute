package com.elearning.simplwelearninginstitute.vo.converter.instittueVos;

import com.elearning.simplwelearninginstitute.entities.Parcour;
import com.elearning.simplwelearninginstitute.vo.converter.EtudiantConverter;
import com.elearning.simplwelearninginstitute.vo.converter.ProfConverter;
import com.elearning.simplwelearninginstitute.vo.intern.ParcourVo;
import com.elearning.simplwelearninginstitute.vo.intern.institute.ParcourInstituteVo;
import com.elearning.simplwelearninginstitute.vo.utils.AbstractConverter;
import com.elearning.simplwelearninginstitute.vo.utils.DateUtil;

public class ParcourInstituteConverter extends AbstractConverter<Parcour, ParcourInstituteVo> {
    @Override
    public Parcour toItem(ParcourInstituteVo parcourInstituteVo) {
        return null;
    }

    @Override
    public ParcourInstituteVo toVo(Parcour item) {
        if (item == null) {
            return null;
        } else {
            ParcourInstituteVo parcourVo = new ParcourInstituteVo();
            parcourVo.setId(item.getId());
            parcourVo.setTitle(item.getTitle());
            parcourVo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
            parcourVo.setDescription(item.getDescription());
            return parcourVo;
        }
    }
}
