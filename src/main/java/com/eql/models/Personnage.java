package com.eql.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Personnage")
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String name;

    @Column(name = "prenom", nullable = false)
    private String surname;
    @ManyToOne
    private User user;

    @OneToOne
    @JoinColumn(name = "equipement_id", referencedColumnName = "id")
    Equipement equipement;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stat_id", referencedColumnName = "id")
    Stat stat;
    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "id")
    Race race;

}
