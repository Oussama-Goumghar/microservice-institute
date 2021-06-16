package com.elearning.simplwelearninginstitute.vo.intern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EtudiantVo {
    private Long id;
    private String telephone;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private String sex;
    private ParcourVo parcourVo;
    private InstituteVo instituteVo;
}
