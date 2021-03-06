package com.elearning.simplwelearninginstitute.vo.intern;

import com.elearning.simplwelearninginstitute.vo.intern.institute.InstituteVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProfVo {
    private Long id;
    private String login;
    private String password;
    private String email;
    private String telephone;
    private String sex;
    private String prenom;
    private String nom;
    private InstituteVo instituteVo;
    private ParcourVo parcourVo;
}
