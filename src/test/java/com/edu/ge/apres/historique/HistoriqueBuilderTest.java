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
    HistoriqueBuilder historiqueBuilder;

    private MatriceType getMatriceType() {
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

        return new MatriceType("Matrice de test", matriceTypeFormations);
    }

    @Test
    public void testXLSImport() {

        try {
            final InputStream is = this.getClass().getResourceAsStream("/historiques/historique-2013-2016.xlsx");
            final MatriceType matriceType = getMatriceType();
            Historique historique = new Historique("Histo ES 2", 2013, 2016,
                    "application/json; charset=utf-8", matriceType);
            historique = historiqueBuilder.importDataToHistorique(is, historique);
            final byte[] data = historique.getData();
            assertThat(data == null).isTrue();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
