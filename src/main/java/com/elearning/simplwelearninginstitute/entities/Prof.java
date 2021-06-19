package com.elearning.simplwelearninginstitute.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prof implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    private String telephone;
    private String sex;
    private String prenom;

    private String nom;
    @ManyToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference(value = "intitute-profs")
    private Institute institute;
    @ManyToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference(value = "parcour-profs")
    private Parcour parcour;


}
