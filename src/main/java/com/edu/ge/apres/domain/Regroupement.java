package com.edu.ge.apres.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Regroupement.
 */
@Entity
@Table(name = "regroupement")
public class Regroupement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "regroupement")
    @JsonIgnore
    private Set<Formation> formations = new HashSet<>();

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Regroupement nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public Regroupement formations(Set<Formation> formations) {
        this.formations = formations;
        return this;
    }

    public Regroupement addFormation(Formation formation) {
        this.formations.add(formation);
        formation.setRegroupement(this);
        return this;
    }

    public Regroupement removeFormation(Formation formation) {
        this.formations.remove(formation);
        formation.setRegroupement(null);
        return this;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Regroupement regroupement = (Regroupement) o;
        if (regroupement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), regroupement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Regroupement{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            "}";
    }
}
