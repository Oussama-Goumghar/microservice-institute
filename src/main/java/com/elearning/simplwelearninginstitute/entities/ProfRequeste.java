package com.elearning.simplwelearninginstitute.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    private String login;
    private String password;
    private String email;
    private String telephone;
    private String sex;
    private String cv;
    private String prenom;
    private String nom;
    private boolean etat;
    @ManyToOne
    private Institute institute;

    @ManyToOne
    private Parcour parcour;
}
