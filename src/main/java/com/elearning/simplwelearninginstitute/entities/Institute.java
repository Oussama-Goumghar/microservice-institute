package com.elearning.simplwelearninginstitute.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @JsonIgnoreProperties({"institute"})
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "institute",  cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"institute"})
    private List<Prof> profs;


}
