package com.edu.ge.apres.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Etude.
 */
//@Entity
@Table(name = "etude")
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

    @NotNull
    @Lob
    @Column(name = "resultat_taux", nullable = false)
    private byte[] resultatTaux;

    @Column(name = "resultat_taux_content_type", nullable = false)
    private String resultatTauxContentType;

    @ManyToOne
    private Historique historique;

    @ManyToOne
    private MatriceType matriceType;

    @ManyToOne
    private FormuleVersion formule;

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

    public byte[] getResultatTaux() {
        return resultatTaux;
    }

    public Etude resultatTaux(byte[] resultatTaux) {
        this.resultatTaux = resultatTaux;
        return this;
    }

    public void setResultatTaux(byte[] resultatTaux) {
        this.resultatTaux = resultatTaux;
    }

    public String getResultatTauxContentType() {
        return resultatTauxContentType;
    }

    public Etude resultatTauxContentType(String resultatTauxContentType) {
        this.resultatTauxContentType = resultatTauxContentType;
        return this;
    }

    public void setResultatTauxContentType(String resultatTauxContentType) {
        this.resultatTauxContentType = resultatTauxContentType;
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

    public MatriceType getMatriceType() {
        return matriceType;
    }

    public Etude matriceType(MatriceType matriceType) {
        this.matriceType = matriceType;
        return this;
    }

    public void setMatriceType(MatriceType matriceType) {
        this.matriceType = matriceType;
    }

    public FormuleVersion getFormule() {
        return formule;
    }

    public Etude formule(FormuleVersion formuleVersion) {
        this.formule = formuleVersion;
        return this;
    }

    public void setFormule(FormuleVersion formuleVersion) {
        this.formule = formuleVersion;
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
            ", resultatTaux='" + getResultatTaux() + "'" +
            ", resultatTauxContentType='" + resultatTauxContentType + "'" +
            "}";
    }
}
