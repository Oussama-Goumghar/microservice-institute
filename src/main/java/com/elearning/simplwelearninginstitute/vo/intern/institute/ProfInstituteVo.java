package com.elearning.simplwelearninginstitute.vo.intern.institute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProfInstituteVo {
    private Long id;
    private String login;
    private String password;
    private String email;
    private String telephone;
    private String sex;
    private String prenom;
    private String nom;
}
