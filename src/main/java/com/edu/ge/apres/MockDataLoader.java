package com.edu.ge.apres;

import com.edu.ge.apres.domain.*;
import com.edu.ge.apres.domain.enumeration.FormuleType;
import com.edu.ge.apres.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class MockDataLoader implements CommandLineRunner {

    private final RegroupementRepository regroupementRepository;
    private final FormationRepository formationRepository;
    private final MatriceTypeFormationRepository matriceTypeFormationRepository;
    private final MatriceTypeRepository matriceTypeRepository;
    private final HistoriqueRepository historiqueRepository;
    private final FormuleRepository formuleRepository;
    private final EtudeFormuleFormationRepository etudeFormuleFormationRepository;
    private final EtudeRepository etudeRepository;

    private MatriceType testMatriceType;
    private Historique testHistorique;
    private Etude testEtude;


    public MockDataLoader(RegroupementRepository regroupementRepository,
                          FormationRepository formationRepository,
                          MatriceTypeFormationRepository matriceTypeFormationRepository,
                          MatriceTypeRepository matriceTypeRepository,
                          HistoriqueRepository historiqueRepository,
                          FormuleRepository formuleRepository,
                          EtudeFormuleFormationRepository etudeFormuleFormationRepository,
                          EtudeRepository etudeRepository) {
        this.regroupementRepository = regroupementRepository;
        this.formationRepository = formationRepository;
        this.matriceTypeFormationRepository = matriceTypeFormationRepository;
        this.matriceTypeRepository = matriceTypeRepository;
        this.historiqueRepository = historiqueRepository;
        this.formuleRepository = formuleRepository;
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
        addEtudeFormuleFormations();
        addEtudes();
    }

    private void addEtudes() {
        // TODO
    }

    private void addEtudeFormuleFormations() {
        // TODO
    }

    private void addFormules() {
        Formule moyenne2ans = new Formule(FormuleType.MOYENNE, "Moyenne sur 2 ans", "");
        Formule tauxConstant = new Formule(FormuleType.TAUX_CONSTANT, "Taux constant", "");
        Formule tendanceAmortie = new Formule(FormuleType.TENDANCE_AMORTIE, "Tendance amortie (coef 2)", "");
        formuleRepository.save(moyenne2ans);
        formuleRepository.save(tauxConstant);
        formuleRepository.save(tendanceAmortie);
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

        Formation formation11CO = new Formation("11CO", "11e CO", regroupement);
        Formation formationACPO = new Formation("11ACPO", "ACPO", regroupement);
        Formation formationCTP = new Formation("CTP", "CTP", regroupement);
        Formation formationPREPEC = new Formation("PREP_EC", "Classe de transition prep EC", regroupement);
        Formation formationPREPECG = new Formation("PREP_ECG", "Classe de transition prep  ECG", regroupement);
        Formation formationCOOP = new Formation("COOP", "Stages insertion COOP", regroupement);
        Formation formationPREPCFP = new Formation("PREP_CFP", "Classe prép pro dans les CFP", regroupement);
        Formation formationCG1 = new Formation("CG1", "Filière gymnasiale - Degré 1", regroupement);
        Formation formationCG2 = new Formation("CG2", "Filière gymnasiale - Degré 2", regroupement);
        Formation formationCG3 = new Formation("CG3", "Filière gymnasiale - Degré 3", regroupement);
        Formation formationCG4 = new Formation("CG4", "Filière gymnasiale - Degré 4", regroupement);
        Formation formationECG1 = new Formation("ECG1", "Filière de culture générale - Degré 1", regroupement);
        Formation formationECG2 = new Formation("ECG2", "Filière de culture générale - Degré 2", regroupement);
        Formation formationECG3 = new Formation("ECG3", "Filière de culture générale - Degré 3", regroupement);
        Formation formationMatuSpe = new Formation("Matu_spe", "Filière de culture générale - Maturité spécialisée", regroupement);
        Formation formationPROPT1 = new Formation("PRO_PT_1", "Formation professionnelle plein temps - Degré 1", regroupement);

        formationRepository.save(formation11CO);
        formationRepository.save(formationACPO);
        formationRepository.save(formationCTP);
        formationRepository.save(formationPREPEC);
        formationRepository.save(formationPREPECG);
        formationRepository.save(formationCOOP);
        formationRepository.save(formationPREPCFP);
        formationRepository.save(formationCG1);
        formationRepository.save(formationCG2);
        formationRepository.save(formationCG3);
        formationRepository.save(formationCG4);
        formationRepository.save(formationECG1);
        formationRepository.save(formationECG2);
        formationRepository.save(formationECG2);
        formationRepository.save(formationECG3);
        formationRepository.save(formationMatuSpe);
        formationRepository.save(formationPROPT1);

        MatriceTypeFormation mtFormation11CO = new MatriceTypeFormation(true, 1, formation11CO);
        MatriceTypeFormation mtFormationACPO = new MatriceTypeFormation(false, 2, formationACPO);
        MatriceTypeFormation mtFormationCTP = new MatriceTypeFormation(true, 3, formationCTP);
        MatriceTypeFormation mtFormationPREPEC = new MatriceTypeFormation(true, 4, formationPREPEC);
        MatriceTypeFormation mtFormationPREPECG = new MatriceTypeFormation(true, 5, formationPREPECG);
        MatriceTypeFormation mtFormationCOOP = new MatriceTypeFormation(true, 6, formationCOOP);
        MatriceTypeFormation mtFormationPREPCFP = new MatriceTypeFormation(true, 7, formationPREPCFP);

        matriceTypeFormationRepository.save(mtFormation11CO);
        matriceTypeFormationRepository.save(mtFormationACPO);
        matriceTypeFormationRepository.save(mtFormationCTP);
        matriceTypeFormationRepository.save(mtFormationPREPEC);
        matriceTypeFormationRepository.save(mtFormationPREPECG);
        matriceTypeFormationRepository.save(mtFormationCOOP);
        matriceTypeFormationRepository.save(mtFormationPREPCFP);

        testMatriceType = new MatriceType("Matrice ES2", new HashSet<>());
        testMatriceType.addMatriceTypeFormation(mtFormation11CO);
        testMatriceType.addMatriceTypeFormation(mtFormationACPO);
        testMatriceType.addMatriceTypeFormation(mtFormationCTP);
        testMatriceType.addMatriceTypeFormation(mtFormationPREPEC);
        testMatriceType.addMatriceTypeFormation(mtFormationPREPECG);
        testMatriceType.addMatriceTypeFormation(mtFormationCOOP);
        testMatriceType.addMatriceTypeFormation(mtFormationPREPCFP);

        matriceTypeRepository.save(testMatriceType);
    }

    private void addRegroupements() {
        addFormations(regroupementRepository.save(new Regroupement("ES 2")));
    }
}
