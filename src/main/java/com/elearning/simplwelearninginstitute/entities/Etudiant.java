package com.elearning.simplwelearninginstitute.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String telephone;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private String sex;
    @ManyToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference(value = "intitute-etudiants")
    private Institute institute;
    @ManyToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference(value = "parcour-etudiants")
    private Parcour parcour;


}
