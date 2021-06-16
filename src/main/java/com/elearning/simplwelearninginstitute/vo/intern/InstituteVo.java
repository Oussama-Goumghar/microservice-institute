package com.elearning.simplwelearninginstitute.vo.intern;

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
    private List<EtudiantVo> etudiantVos;
    private List<ProfVo> profVos;
    private List<ParcourVo> parcourVos;
}
