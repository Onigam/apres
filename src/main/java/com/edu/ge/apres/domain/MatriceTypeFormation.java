package com.edu.ge.apres.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A MatriceTypeFormation.
 */
@Entity
@Table(name = "mat_type_form")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MatriceTypeFormation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "classe_alimentation", nullable = false)
    private Boolean classeAlimentation;

    @NotNull
    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @ManyToOne
    private Formation formation;

    @ManyToOne
    private MatriceType matriceType;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isClasseAlimentation() {
        return classeAlimentation;
    }

    public MatriceTypeFormation classeAlimentation(Boolean classeAlimentation) {
        this.classeAlimentation = classeAlimentation;
        return this;
    }

    public void setClasseAlimentation(Boolean classeAlimentation) {
        this.classeAlimentation = classeAlimentation;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public MatriceTypeFormation ordre(Integer ordre) {
        this.ordre = ordre;
        return this;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public Formation getFormation() {
        return formation;
    }

    public MatriceTypeFormation formation(Formation formation) {
        this.formation = formation;
        return this;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public MatriceType getMatriceType() {
        return matriceType;
    }

    public MatriceTypeFormation matriceType(MatriceType matriceType) {
        this.matriceType = matriceType;
        return this;
    }

    public void setMatriceType(MatriceType matriceType) {
        this.matriceType = matriceType;
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
        MatriceTypeFormation matriceTypeFormation = (MatriceTypeFormation) o;
        if (matriceTypeFormation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), matriceTypeFormation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MatriceTypeFormation{" +
            "id=" + getId() +
            ", classeAlimentation='" + isClasseAlimentation() + "'" +
            ", ordre='" + getOrdre() + "'" +
            "}";
    }
}
