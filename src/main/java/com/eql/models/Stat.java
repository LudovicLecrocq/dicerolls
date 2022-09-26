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
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int maxHP;
    private int hp;
    private int strenght;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    @OneToOne(mappedBy = "stat")
    Personnage personnage;

    public Stat(int maxHP, int hp, int strenght, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Personnage personnage) {
        this.maxHP = maxHP;
        this.hp = hp;
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.personnage = personnage;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "id=" + id +
                ", maxHP=" + maxHP +
                ", hp=" + hp +
                ", strenght=" + strenght +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", personnage=" + personnage +
                '}';
    }
}
