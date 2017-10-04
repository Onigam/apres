package com.edu.ge.apres.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A EtudeFormuleFormation.
 */
@Entity
@Table(name = "et_formu_forma")
public class EtudeFormuleFormation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "annee_debut")
    private Integer anneeDebut;

    @ManyToOne
    private MatriceTypeFormation formation;

    @ManyToOne
    private Formule formule;

    @ManyToOne
    private Etude etude;

    protected EtudeFormuleFormation() {
    }

    public EtudeFormuleFormation(Integer anneeDebut, MatriceTypeFormation formation, Formule formule, Etude etude) {
        this.anneeDebut = anneeDebut;
        this.formation = formation;
        this.formule = formule;
        this.etude = etude;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnneeDebut() {
        return anneeDebut;
    }

    public EtudeFormuleFormation anneeDebut(Integer anneeDebut) {
        this.anneeDebut = anneeDebut;
        return this;
    }

    public void setAnneeDebut(Integer anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public MatriceTypeFormation getFormation() {
        return formation;
    }

    public EtudeFormuleFormation formation(MatriceTypeFormation matriceTypeFormation) {
        this.formation = matriceTypeFormation;
        return this;
    }

    public void setFormation(MatriceTypeFormation matriceTypeFormation) {
        this.formation = matriceTypeFormation;
    }

    public Formule getFormule() {
        return formule;
    }

    public EtudeFormuleFormation formule(Formule formule) {
        this.formule = formule;
        return this;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
    }

    public Etude getEtude() {
        return etude;
    }

    public EtudeFormuleFormation etude(Etude etude) {
        this.etude = etude;
        return this;
    }

    public void setEtude(Etude etude) {
        this.etude = etude;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EtudeFormuleFormation etudeFormuleFormation = (EtudeFormuleFormation) o;
        if (etudeFormuleFormation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), etudeFormuleFormation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EtudeFormuleFormation{" +
            "id=" + getId() +
            ", anneeDebut='" + getAnneeDebut() + "'" +
            "}";
    }
}
