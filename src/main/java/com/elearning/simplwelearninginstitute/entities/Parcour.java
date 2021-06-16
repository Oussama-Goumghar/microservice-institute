package com.elearning.simplwelearninginstitute.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ManyToOne
    private Institute institute;

    @OneToMany(mappedBy = "parcour", cascade = {CascadeType.ALL})
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "parcour", cascade = {CascadeType.ALL})
    private List<Prof> profs;

    @JsonBackReference
    public Institute getInstitute() {
        return institute;
    }
    @JsonManagedReference
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    @JsonManagedReference
    public List<Prof> getProfs() {
        return profs;
    }
}
