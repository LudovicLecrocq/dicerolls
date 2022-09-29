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
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long sessionId;

    private String sName;
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "session")
    private List<Personnage> personnages = new ArrayList<>();

    @Override
    public String toString() {
        return "Session{" +
                "id=" + sessionId +
                ", sName='" + sName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
