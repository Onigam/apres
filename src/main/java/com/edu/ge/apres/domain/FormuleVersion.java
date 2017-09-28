package com.edu.ge.apres.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A FormuleVersion.
 */
@Entity
@Table(name = "form_version")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FormuleVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "valeur")
    private String valeur;

    @ManyToOne
    private Formule formule;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public FormuleVersion version(Integer version) {
        this.version = version;
        return this;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getValeur() {
        return valeur;
    }

    public FormuleVersion valeur(String valeur) {
        this.valeur = valeur;
        return this;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Formule getFormule() {
        return formule;
    }

    public FormuleVersion formule(Formule formule) {
        this.formule = formule;
        return this;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
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
        FormuleVersion formuleVersion = (FormuleVersion) o;
        if (formuleVersion.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), formuleVersion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FormuleVersion{" +
            "id=" + getId() +
            ", version='" + getVersion() + "'" +
            ", valeur='" + getValeur() + "'" +
            "}";
    }
}
