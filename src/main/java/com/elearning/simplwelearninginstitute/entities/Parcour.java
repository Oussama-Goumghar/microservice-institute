package com.elearning.simplwelearninginstitute.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"parcour"})
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "parcour", cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"parcour"})
    private List<Prof> profs;
}
