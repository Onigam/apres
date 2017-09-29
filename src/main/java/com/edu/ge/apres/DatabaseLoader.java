package com.edu.ge.apres;

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
        addFormations();
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

    private void addFormations() {
        // TODO
    }

    private void addRegroupements() {
        // TODO
    }
}
