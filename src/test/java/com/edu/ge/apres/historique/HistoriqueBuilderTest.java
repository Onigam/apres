package com.edu.ge.apres.historique;

import com.edu.ge.apres.ApresApplication;
import com.edu.ge.apres.domain.Historique;
import com.edu.ge.apres.domain.MatriceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApresApplication.class)
public class HistoriqueBuilderTest {

    @Autowired
    HistoriqueBuilder historiqueBuilder;

    @Test
    public void testXLSImport() {

        try {
            final InputStream is = this.getClass().getResourceAsStream("/historiques/historique-2013-2016.xlsx");
            final MatriceType matriceType = null;
            Historique historique = new Historique("Histo ES 2", 2013, 2016,
                    "application/json; charset=utf-8", matriceType);
            historique = historiqueBuilder.importDataToHistorique(is, historique);
            final byte[] data = historique.getData();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
