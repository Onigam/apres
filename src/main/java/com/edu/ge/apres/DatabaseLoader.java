package com.edu.ge.apres;

import com.edu.ge.apres.domain.Formation;
import com.edu.ge.apres.domain.Regroupement;
import com.edu.ge.apres.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final RegroupementRepository regroupementRepository;
    private final FormationRepository formationRepository;
    private final MatriceTypeFormationRepository matriceTypeFormationRepository;
    private final MatriceTypeRepository matriceTypeRepository;
    private final HistoriqueRepository historiqueRepository;
    private final FormuleRepository formuleRepository;
    private final FormuleVersionRepository formuleVersionRepository;
    private final EtudeFormuleFormationRepository etudeFormuleFormationRepository;
    private final EtudeRepository etudeRepository;

    public DatabaseLoader(RegroupementRepository regroupementRepository,
                          FormationRepository formationRepository,
                          MatriceTypeFormationRepository matriceTypeFormationRepository,
                          MatriceTypeRepository matriceTypeRepository,
                          HistoriqueRepository historiqueRepository,
                          FormuleRepository formuleRepository,
                          FormuleVersionRepository formuleVersionRepository,
                          EtudeFormuleFormationRepository etudeFormuleFormationRepository,
                          EtudeRepository etudeRepository) {
        this.regroupementRepository = regroupementRepository;
        this.formationRepository = formationRepository;
        this.matriceTypeFormationRepository = matriceTypeFormationRepository;
        this.matriceTypeRepository = matriceTypeRepository;
        this.historiqueRepository = historiqueRepository;
        this.formuleRepository = formuleRepository;
        this.formuleVersionRepository = formuleVersionRepository;
        this.etudeFormuleFormationRepository = etudeFormuleFormationRepository;
        this.etudeRepository = etudeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        addRegroupements();
        addMatriceTypeFormations();
        addMatriceTypes();
        addHistoriques();
        addFormules();
        addFormuleVersions();
        addEtudeFormuleFormations();
        addEtudes();
    }

    private void addEtudes() {
        // TODO
    }

    private void addEtudeFormuleFormations() {
        // TODO
    }

    private void addFormuleVersions() {
        // TODO
    }

    private void addFormules() {
        // TODO
    }

    private void addHistoriques() {
        // TODO
    }

    private void addMatriceTypes() {
        // TODO
    }

    private void addMatriceTypeFormations() {
        // TODO
    }

    private void addFormations(Regroupement regroupement) {
        formationRepository.save(new Formation("11CO", "11e CO", regroupement));
        formationRepository.save(new Formation("11ACPO", "ACPO", regroupement));
        formationRepository.save(new Formation("CTP", "CTP", regroupement));
        formationRepository.save(new Formation("PREP_EC", "Classe de transition prep EC", regroupement));
        formationRepository.save(new Formation("PREP_ECG", "Classe de transition prep  ECG", regroupement));
        formationRepository.save(new Formation("COOP", "Stages insertion COOP", regroupement));
        formationRepository.save(new Formation("PREP_CFP", "Classe prép pro dans les CFP", regroupement));
        formationRepository.save(new Formation("CG1", "Filière gymnasiale - Degré 1", regroupement));
        formationRepository.save(new Formation("CG2", "Filière gymnasiale - Degré 2", regroupement));
        formationRepository.save(new Formation("CG3", "Filière gymnasiale - Degré 3", regroupement));
        formationRepository.save(new Formation("CG4", "Filière gymnasiale - Degré 4", regroupement));
        formationRepository.save(new Formation("ECG1", "Filière de culture générale - Degré 1", regroupement));
        formationRepository.save(new Formation("ECG2", "Filière de culture générale - Degré 2", regroupement));
        formationRepository.save(new Formation("ECG3", "Filière de culture générale - Degré 3", regroupement));
        formationRepository.save(new Formation("Matu_spe", "Filière de culture générale - Maturité spécialisée", regroupement));
        formationRepository.save(new Formation("PRO_PT_1", "Formation professionnelle plein temps - Degré 1", regroupement));
    }

    private void addRegroupements() {
        addFormations(regroupementRepository.save(new Regroupement("ES 2")));
    }
}
