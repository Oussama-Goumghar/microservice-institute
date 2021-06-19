package com.elearning.simplwelearninginstitute.vo.intern.institute;

import com.elearning.simplwelearninginstitute.vo.intern.EtudiantVo;
import com.elearning.simplwelearninginstitute.vo.intern.ParcourVo;
import com.elearning.simplwelearninginstitute.vo.intern.ProfVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InstituteVo {
    private Long id;
    private String title;
    private String telephone;
    private String login;
    private String email;
    private String password;
    private List<EtudiantInstituteVo> etudiantVos;
    private List<ProfInstituteVo> profVos;
    private List<ParcourInstituteVo> parcourVos;
}
