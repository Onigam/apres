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
 * A Etude.
 */
@Entity
@Table(name = "etude")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Etude implements Serializable {

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
    @Column(name = "nb_annee_projection", nullable = false)
    private Integer nbAnneeProjection;

    @NotNull
    @Lob
    @Column(name = "effectifs_classes_alim", nullable = false)
    private byte[] effectifsClassesAlim;

    @Column(name = "effectifs_classes_alim_content_type", nullable = false)
    private String effectifsClassesAlimContentType;

    @NotNull
    @Lob
    @Column(name = "effectifs_autres_origines", nullable = false)
    private byte[] effectifsAutresOrigines;

    @Column(name = "effectifs_autres_origines_content_type", nullable = false)
    private String effectifsAutresOriginesContentType;

    @NotNull
    @Lob
    @Column(name = "resultat_effectif", nullable = false)
    private byte[] resultatEffectif;

    @Column(name = "resultat_effectif_content_type", nullable = false)
    private String resultatEffectifContentType;

    @OneToMany(mappedBy = "etude")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<EtudeFormuleFormation> formuleFormations = new HashSet<>();

    @ManyToOne
    private Historique historique;

    @ManyToOne
    private FormuleVersion formuleGlobale;

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

    public Etude nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAnneeDebut() {
        return anneeDebut;
    }

    public Etude anneeDebut(Integer anneeDebut) {
        this.anneeDebut = anneeDebut;
        return this;
    }

    public void setAnneeDebut(Integer anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public Integer getAnneeFin() {
        return anneeFin;
    }

    public Etude anneeFin(Integer anneeFin) {
        this.anneeFin = anneeFin;
        return this;
    }

    public void setAnneeFin(Integer anneeFin) {
        this.anneeFin = anneeFin;
    }

    public Integer getNbAnneeProjection() {
        return nbAnneeProjection;
    }

    public Etude nbAnneeProjection(Integer nbAnneeProjection) {
        this.nbAnneeProjection = nbAnneeProjection;
        return this;
    }

    public void setNbAnneeProjection(Integer nbAnneeProjection) {
        this.nbAnneeProjection = nbAnneeProjection;
    }

    public byte[] getEffectifsClassesAlim() {
        return effectifsClassesAlim;
    }

    public Etude effectifsClassesAlim(byte[] effectifsClassesAlim) {
        this.effectifsClassesAlim = effectifsClassesAlim;
        return this;
    }

    public void setEffectifsClassesAlim(byte[] effectifsClassesAlim) {
        this.effectifsClassesAlim = effectifsClassesAlim;
    }

    public String getEffectifsClassesAlimContentType() {
        return effectifsClassesAlimContentType;
    }

    public Etude effectifsClassesAlimContentType(String effectifsClassesAlimContentType) {
        this.effectifsClassesAlimContentType = effectifsClassesAlimContentType;
        return this;
    }

    public void setEffectifsClassesAlimContentType(String effectifsClassesAlimContentType) {
        this.effectifsClassesAlimContentType = effectifsClassesAlimContentType;
    }

    public byte[] getEffectifsAutresOrigines() {
        return effectifsAutresOrigines;
    }

    public Etude effectifsAutresOrigines(byte[] effectifsAutresOrigines) {
        this.effectifsAutresOrigines = effectifsAutresOrigines;
        return this;
    }

    public void setEffectifsAutresOrigines(byte[] effectifsAutresOrigines) {
        this.effectifsAutresOrigines = effectifsAutresOrigines;
    }

    public String getEffectifsAutresOriginesContentType() {
        return effectifsAutresOriginesContentType;
    }

    public Etude effectifsAutresOriginesContentType(String effectifsAutresOriginesContentType) {
        this.effectifsAutresOriginesContentType = effectifsAutresOriginesContentType;
        return this;
    }

    public void setEffectifsAutresOriginesContentType(String effectifsAutresOriginesContentType) {
        this.effectifsAutresOriginesContentType = effectifsAutresOriginesContentType;
    }

    public byte[] getResultatEffectif() {
        return resultatEffectif;
    }

    public Etude resultatEffectif(byte[] resultatEffectif) {
        this.resultatEffectif = resultatEffectif;
        return this;
    }

    public void setResultatEffectif(byte[] resultatEffectif) {
        this.resultatEffectif = resultatEffectif;
    }

    public String getResultatEffectifContentType() {
        return resultatEffectifContentType;
    }

    public Etude resultatEffectifContentType(String resultatEffectifContentType) {
        this.resultatEffectifContentType = resultatEffectifContentType;
        return this;
    }

    public void setResultatEffectifContentType(String resultatEffectifContentType) {
        this.resultatEffectifContentType = resultatEffectifContentType;
    }

    public Set<EtudeFormuleFormation> getFormuleFormations() {
        return formuleFormations;
    }

    public Etude formuleFormations(Set<EtudeFormuleFormation> etudeFormuleFormations) {
        this.formuleFormations = etudeFormuleFormations;
        return this;
    }

    public Etude addFormuleFormation(EtudeFormuleFormation etudeFormuleFormation) {
        this.formuleFormations.add(etudeFormuleFormation);
        etudeFormuleFormation.setEtude(this);
        return this;
    }

    public Etude removeFormuleFormation(EtudeFormuleFormation etudeFormuleFormation) {
        this.formuleFormations.remove(etudeFormuleFormation);
        etudeFormuleFormation.setEtude(null);
        return this;
    }

    public void setFormuleFormations(Set<EtudeFormuleFormation> etudeFormuleFormations) {
        this.formuleFormations = etudeFormuleFormations;
    }

    public Historique getHistorique() {
        return historique;
    }

    public Etude historique(Historique historique) {
        this.historique = historique;
        return this;
    }

    public void setHistorique(Historique historique) {
        this.historique = historique;
    }

    public FormuleVersion getFormuleGlobale() {
        return formuleGlobale;
    }

    public Etude formuleGlobale(FormuleVersion formuleVersion) {
        this.formuleGlobale = formuleVersion;
        return this;
    }

    public void setFormuleGlobale(FormuleVersion formuleVersion) {
        this.formuleGlobale = formuleVersion;
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
        Etude etude = (Etude) o;
        if (etude.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), etude.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Etude{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", anneeDebut='" + getAnneeDebut() + "'" +
            ", anneeFin='" + getAnneeFin() + "'" +
            ", nbAnneeProjection='" + getNbAnneeProjection() + "'" +
            ", effectifsClassesAlim='" + getEffectifsClassesAlim() + "'" +
            ", effectifsClassesAlimContentType='" + effectifsClassesAlimContentType + "'" +
            ", effectifsAutresOrigines='" + getEffectifsAutresOrigines() + "'" +
            ", effectifsAutresOriginesContentType='" + effectifsAutresOriginesContentType + "'" +
            ", resultatEffectif='" + getResultatEffectif() + "'" +
            ", resultatEffectifContentType='" + resultatEffectifContentType + "'" +
            "}";
    }
}
