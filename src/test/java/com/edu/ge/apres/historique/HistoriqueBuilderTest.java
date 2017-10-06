package com.edu.ge.apres.historique;

import com.edu.ge.apres.ApresApplication;
import com.edu.ge.apres.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApresApplication.class)
public class HistoriqueBuilderTest {

    @Autowired
    private HistoriqueBuilder historiqueBuilder;

    private Historique historique;
    private MatriceType matriceType;

    @Test
    public void testXLSImport() throws HistoriqueException {

        final InputStream is = this.getClass().getResourceAsStream("/historiques/historique-2013-2016.xlsx");
        historique = historiqueBuilder.importDataToHistorique(is, getHistorique());
        final byte[] data = historique.getData();
        assertThat(data == null).isTrue();
    }

    @Test
    public void testXLSUnconsistentRowImport() throws HistoriqueException {
        final InputStream is = this.getClass().getResourceAsStream("/historiques/historique-unconsistent-row-2013-2016.xlsx");

        try {
            historiqueBuilder.importDataToHistorique(is, getHistorique());
        } catch (final HistoriqueException e) {
            assertThat(e.getMessage().equals("Erreur de cohérence des totaux dans l'onglet 0 sur la ligne 3")).isTrue();
        }
    }

    @Test
    public void testXLSUnconsistentColumnImport() throws HistoriqueException {
        final InputStream is = this.getClass().getResourceAsStream("/historiques/historique-unconsistent-column-2013-2016.xlsx");

        try {
            historiqueBuilder.importDataToHistorique(is, getHistorique());
        } catch (final HistoriqueException e) {
            assertThat(e.getMessage().equals("Erreur de cohérence des totaux dans l'onglet 0 sur la colonne 4")).isTrue();
        }
    }

    private MatriceType getMatriceType() {

        if (matriceType == null) {
            final Regroupement regroupement = new Regroupement("ES 2");
            for (int i = 0; i < 29; i++) {
                final Formation form = new Formation("FORM_" + i, "Formation " + i, regroupement);
                regroupement.addFormation(form);
            }

            final Set<MatriceTypeFormation> matriceTypeFormations = new HashSet<>();
            final Formation[] formations = regroupement.getFormations().stream().toArray(Formation[]::new);
            for (int i = 0; i < 3; i++) {
                matriceTypeFormations.add(new MatriceTypeFormation(true, i, formations[i]));
            }

            for (int i = 3; i < 29; i++) {
                matriceTypeFormations.add(new MatriceTypeFormation(false, i, formations[i]));
            }

            matriceType = new MatriceType("Matrice de test", matriceTypeFormations);
        }

        return matriceType;
    }

    private Historique getHistorique() {
        if (historique == null) {
            historique = new Historique("Histo ES 2", 2013, 2016,
                    "application/json; charset=utf-8", getMatriceType());
        }

        return historique;
    }
}
