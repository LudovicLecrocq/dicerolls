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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long eId;
    private String eName;
    private Long ehp;

    @Override
    public String toString() {
        return "Enemy{" +
                "id=" + eId +
                ", eName='" + eName + '\'' +
                ", ehp=" + ehp +
                '}';
    }
}
