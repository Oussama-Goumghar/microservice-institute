package com.elearning.simplwelearninginstitute.vo.intern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProfRequestVo {

    private Long id;
    private String login;
    private String password;
    private String email;
    private String telephone;
    private String sex;
    private String cv;
    private String prenom;
    private String nom;
    private boolean etat;
    private InstituteVo instituteVo;
    private ParcourVo parcourVo;
}
