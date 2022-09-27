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
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "equipment")
    private Personnage personnage;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "equip_weapon",
    joinColumns = @JoinColumn(name = "equipId"),
    inverseJoinColumns = @JoinColumn(name = "weaponId"))
    private List<Weapon> weapons = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "equip_armour",
            joinColumns = @JoinColumn(name = "equipId"),
            inverseJoinColumns = @JoinColumn(name = "armourId"))
    private List<Armour> armours = new ArrayList<>();

}
