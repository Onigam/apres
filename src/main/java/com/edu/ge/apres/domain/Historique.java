package com.edu.ge.apres.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Historique.
 */
@Entity
@Table(name = "historique")
public class Historique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "annee_debut", nullable = false)
    private Integer anneeDebut;

    @NotNull
    @Column(name = "annee_fin", nullable = false)
    private Integer anneeFin;

    @NotNull
    @Lob
    @Column(name = "data", nullable = false)
    private byte[] data;

    @Column(name = "data_content_type", nullable = false)
    private String dataContentType;

    @ManyToOne
    private MatriceType matriceType;

    protected Historique() {
    }

    public Historique(String nom, Integer anneeDebut, Integer anneeFin, String dataContentType, MatriceType matriceType) {
        this.nom = nom;
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
        this.dataContentType = dataContentType;
        this.matriceType = matriceType;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Historique nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAnneeDebut() {
        return anneeDebut;
    }

    public Historique anneeDebut(Integer anneeDebut) {
        this.anneeDebut = anneeDebut;
        return this;
    }

    public void setAnneeDebut(Integer anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public Integer getAnneeFin() {
        return anneeFin;
    }

    public Historique anneeFin(Integer anneeFin) {
        this.anneeFin = anneeFin;
        return this;
    }

    public void setAnneeFin(Integer anneeFin) {
        this.anneeFin = anneeFin;
    }

    public byte[] getData() {
        return data;
    }

    public Historique data(byte[] data) {
        this.data = data;
        return this;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDataContentType() {
        return dataContentType;
    }

    public Historique dataContentType(String dataContentType) {
        this.dataContentType = dataContentType;
        return this;
    }

    public void setDataContentType(String dataContentType) {
        this.dataContentType = dataContentType;
    }

    public MatriceType getMatriceType() {
        return matriceType;
    }

    public Historique matriceType(MatriceType matriceType) {
        this.matriceType = matriceType;
        return this;
    }

    public void setMatriceType(MatriceType matriceType) {
        this.matriceType = matriceType;
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
        Historique historique = (Historique) o;
        if (historique.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), historique.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Historique{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", anneeDebut='" + getAnneeDebut() + "'" +
            ", anneeFin='" + getAnneeFin() + "'" +
            ", data='" + getData() + "'" +
            ", dataContentType='" + dataContentType + "'" +
            "}";
    }
}
