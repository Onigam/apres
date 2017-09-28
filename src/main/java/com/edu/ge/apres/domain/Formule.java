package com.edu.ge.apres.domain;

import com.edu.ge.apres.domain.enumeration.FormuleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Formule.
 */
//@Entity
@Table(name = "formule")
public class Formule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private FormuleType type;

    @OneToMany(mappedBy = "formule")
    @JsonIgnore
    private Set<FormuleVersion> formuleVersions = new HashSet<>();

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormuleType getType() {
        return type;
    }

    public Formule type(FormuleType type) {
        this.type = type;
        return this;
    }

    public void setType(FormuleType type) {
        this.type = type;
    }

    public Set<FormuleVersion> getFormuleVersions() {
        return formuleVersions;
    }

    public Formule formuleVersions(Set<FormuleVersion> formuleVersions) {
        this.formuleVersions = formuleVersions;
        return this;
    }

    public Formule addFormuleVersion(FormuleVersion formuleVersion) {
        this.formuleVersions.add(formuleVersion);
        formuleVersion.setFormule(this);
        return this;
    }

    public Formule removeFormuleVersion(FormuleVersion formuleVersion) {
        this.formuleVersions.remove(formuleVersion);
        formuleVersion.setFormule(null);
        return this;
    }

    public void setFormuleVersions(Set<FormuleVersion> formuleVersions) {
        this.formuleVersions = formuleVersions;
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
        Formule formule = (Formule) o;
        if (formule.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), formule.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Formule{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            "}";
    }
}
