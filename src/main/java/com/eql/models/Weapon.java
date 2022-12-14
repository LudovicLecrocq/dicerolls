package com.eql.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String wName;
    private Long atqValue;

    @ManyToMany(mappedBy = "weapons")
    private List<Equipement> equipements = new ArrayList<>();

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + wName + '\'' +
                ", atqValue=" + atqValue +
                '}';
    }
}