package com.elearning.simplwelearninginstitute.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Institute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String telephone;
    private String login;
    private String email;
    private String password;
    @OneToMany(mappedBy = "institute", cascade = {CascadeType.ALL})
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "institute",  cascade = {CascadeType.ALL})
    private List<Prof> profs;

    @OneToMany(mappedBy = "institute",  cascade = {CascadeType.ALL})
    private List<Parcour> parcours;

    @JsonManagedReference
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    @JsonManagedReference
    public List<Prof> getProfs() {
        return profs;
    }
    @JsonManagedReference
    public List<Parcour> getParcours() {
        return parcours;
    }
}
