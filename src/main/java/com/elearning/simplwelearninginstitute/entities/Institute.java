package com.elearning.simplwelearninginstitute.entities;


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
    @OneToMany(mappedBy = "institute", cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonManagedReference(value = "intitute-etudiants")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "institute",  cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonManagedReference(value = "intitute-profs")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Prof> profs;

    @OneToMany(mappedBy = "institute",  cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JsonManagedReference(value = "intitute-parcours")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Parcour> parcours;


}
