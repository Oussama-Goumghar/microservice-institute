package com.elearning.simplwelearninginstitute.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfRequeste implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    @NotEmpty
    private String telephone;
    @NotEmpty
    private String sex;

    private String cv;

    private boolean etat;
    @ManyToOne
    private Institute institute;

    @ManyToOne
    private Parcour parcour;
}
