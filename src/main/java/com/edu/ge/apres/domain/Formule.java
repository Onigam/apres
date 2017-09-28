package com.edu.ge.apres.domain;

import com.edu.ge.apres.domain.enumeration.FormuleType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Formule.
 */
@Entity
@Table(name = "formule")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Formule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private FormuleType type;

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
