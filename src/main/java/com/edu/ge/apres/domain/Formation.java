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
 * A Formation.
 */
@Entity
@Table(name = "formation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "nom_court", nullable = false)
    private String nomCourt;

    @NotNull
    @Column(name = "nom_long", nullable = false)
    private String nomLong;

    @ManyToOne
    private Regroupement regroupement;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCourt() {
        return nomCourt;
    }

    public Formation nomCourt(String nomCourt) {
        this.nomCourt = nomCourt;
        return this;
    }

    public void setNomCourt(String nomCourt) {
        this.nomCourt = nomCourt;
    }

    public String getNomLong() {
        return nomLong;
    }

    public Formation nomLong(String nomLong) {
        this.nomLong = nomLong;
        return this;
    }

    public void setNomLong(String nomLong) {
        this.nomLong = nomLong;
    }

    public Regroupement getRegroupement() {
        return regroupement;
    }

    public Formation regroupement(Regroupement regroupement) {
        this.regroupement = regroupement;
        return this;
    }

    public void setRegroupement(Regroupement regroupement) {
        this.regroupement = regroupement;
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
        Formation formation = (Formation) o;
        if (formation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), formation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Formation{" +
            "id=" + getId() +
            ", nomCourt='" + getNomCourt() + "'" +
            ", nomLong='" + getNomLong() + "'" +
            "}";
    }
}
