package com.elearning.simplwelearninginstitute.vo.intern;

import com.elearning.simplwelearninginstitute.vo.intern.institute.EtudiantInstituteVo;
import com.elearning.simplwelearninginstitute.vo.intern.institute.InstituteVo;
import com.elearning.simplwelearninginstitute.vo.intern.institute.ProfInstituteVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ParcourVo {
    private Long id;
    private String title;
    private String description;
    private String dateCreation;
    private InstituteVo instituteVo;
    private List<EtudiantInstituteVo> etudiantVos;
    private List<ProfInstituteVo> profVos;

}
