package com.elearning.simplwelearninginstitute.vo.intern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
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
    private List<EtudiantVo> etudiantVos;
    private List<ProfVo> profVos;

}
