package com.edu.ge.apres.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A FormuleVersion.
 */
//@Entity
@Table(name = "form_version")
public class FormuleVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "jhi_value")
    private String value;

    @OneToMany(mappedBy = "formule")
    @JsonIgnore
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Etude> etudes = new HashSet<>();

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

    public String getValue() {
        return value;
    }

    public FormuleVersion value(String value) {
        this.value = value;
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<Etude> getEtudes() {
        return etudes;
    }

    public FormuleVersion etudes(Set<Etude> etudes) {
        this.etudes = etudes;
        return this;
    }

    public FormuleVersion addEtude(Etude etude) {
        this.etudes.add(etude);
        etude.setFormule(this);
        return this;
    }

    public FormuleVersion removeEtude(Etude etude) {
        this.etudes.remove(etude);
        etude.setFormule(null);
        return this;
    }

    public void setEtudes(Set<Etude> etudes) {
        this.etudes = etudes;
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
            ", value='" + getValue() + "'" +
            "}";
    }
}
