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
 * A MatriceType.
 */
@Entity
@Table(name = "matrice_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MatriceType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "matriceType")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<MatriceTypeFormation> matriceTypeFormations = new HashSet<>();

    @OneToMany(mappedBy = "matriceType")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Historique> historiques = new HashSet<>();

    @OneToMany(mappedBy = "matriceType")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Etude> etudes = new HashSet<>();

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

    public MatriceType nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<MatriceTypeFormation> getMatriceTypeFormations() {
        return matriceTypeFormations;
    }

    public MatriceType matriceTypeFormations(Set<MatriceTypeFormation> matriceTypeFormations) {
        this.matriceTypeFormations = matriceTypeFormations;
        return this;
    }

    public MatriceType addMatriceTypeFormation(MatriceTypeFormation matriceTypeFormation) {
        this.matriceTypeFormations.add(matriceTypeFormation);
        matriceTypeFormation.setMatriceType(this);
        return this;
    }

    public MatriceType removeMatriceTypeFormation(MatriceTypeFormation matriceTypeFormation) {
        this.matriceTypeFormations.remove(matriceTypeFormation);
        matriceTypeFormation.setMatriceType(null);
        return this;
    }

    public void setMatriceTypeFormations(Set<MatriceTypeFormation> matriceTypeFormations) {
        this.matriceTypeFormations = matriceTypeFormations;
    }

    public Set<Historique> getHistoriques() {
        return historiques;
    }

    public MatriceType historiques(Set<Historique> historiques) {
        this.historiques = historiques;
        return this;
    }

    public MatriceType addHistorique(Historique historique) {
        this.historiques.add(historique);
        historique.setMatriceType(this);
        return this;
    }

    public MatriceType removeHistorique(Historique historique) {
        this.historiques.remove(historique);
        historique.setMatriceType(null);
        return this;
    }

    public void setHistoriques(Set<Historique> historiques) {
        this.historiques = historiques;
    }

    public Set<Etude> getEtudes() {
        return etudes;
    }

    public MatriceType etudes(Set<Etude> etudes) {
        this.etudes = etudes;
        return this;
    }

    public MatriceType addEtude(Etude etude) {
        this.etudes.add(etude);
        etude.setMatriceType(this);
        return this;
    }

    public MatriceType removeEtude(Etude etude) {
        this.etudes.remove(etude);
        etude.setMatriceType(null);
        return this;
    }

    public void setEtudes(Set<Etude> etudes) {
        this.etudes = etudes;
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
        MatriceType matriceType = (MatriceType) o;
        if (matriceType.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), matriceType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MatriceType{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            "}";
    }
}
