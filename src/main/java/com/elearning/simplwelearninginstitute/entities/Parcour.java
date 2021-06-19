package com.elearning.simplwelearninginstitute.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parcour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date dateCreation;
    @ManyToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference(value = "intitute-parcours")
    private Institute institute;

    @OneToMany(mappedBy = "parcour", cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonManagedReference(value = "parcour-etudiants")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "parcour", cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonManagedReference(value = "parcour-profs")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Prof> profs;


}
