package com.elearning.simplwelearninginstitute.vo.intern.institute;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ParcourInstituteVo {
    private Long id;
    private String title;
    private String description;
    private String dateCreation;
}
