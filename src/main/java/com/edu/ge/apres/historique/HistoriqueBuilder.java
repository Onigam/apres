package com.edu.ge.apres.historique;

import com.edu.ge.apres.domain.Historique;
import com.edu.ge.apres.domain.MatriceType;
import com.edu.ge.apres.domain.MatriceTypeFormation;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@Service
public class HistoriqueBuilder {

    public Historique importDataToHistorique(final InputStream is, final Historique historique) throws IOException, HistoriqueException {

        final int[][][] data = parseSheets(is, historique);
        //historique.setData(intArrayToBlob(data));
        return historique;
    }

    private int[][][] parseSheets(final InputStream is, final Historique historique) throws IOException, HistoriqueException {

        final XSSFWorkbook excelParser = new XSSFWorkbook(is);
        final int nbMaxOfSheets = excelParser.getNumberOfSheets();
        final int nbSheet = historique.getAnneeFin() - historique.getAnneeDebut();
        final int[][][] result = new int[nbSheet][][];
        final int endSheet = (nbSheet <= nbMaxOfSheets - 1) ? nbSheet : nbMaxOfSheets - 1;

        // Lister chaque année en un tableau de 2 dimensions
        for (int i = 0; i < endSheet; i++) {
            // Vérifier la cohérence des données
            result[i] = parseSheet(excelParser.getSheetAt(i), i, historique.getMatriceType());
        }

        return result;
    }

    private int[][] parseSheet(final XSSFSheet sheet, final int sheetNumber, final MatriceType matriceType) throws IOException, HistoriqueException {

        final Set<MatriceTypeFormation> formations = matriceType.getMatriceTypeFormations();
        final int nbRows = formations.size() + 2;
        final int nbColumns = (int) formations.stream().filter(formation -> !formation.isClasseAlimentation()).count() + 1;

        // On stoque par formation ( 1ere colonne du excel ) avec pour chaque element la repartition sur l'année n+1 sur une autre formation
        final int[][] sheetAsArray = new int[nbRows][nbColumns];

        try {
            // Pour chaque année tester si la valeur de la dernière ligne est égale a la somme des éléments jusqu'a i - 1
            for (int y = 1; y < nbRows + 1; y++) {
                final XSSFRow row = sheet.getRow(y);

                for (int x = 1; x < nbColumns; x++) {
                    sheetAsArray[y - 1][x - 1] = getCellIntValue(row.getCell(x));
                }
            }
        } catch (final Exception e) {
            throw new HistoriqueException("Le format du fichier est incorrect, importation impossible", 0);
        }

        checkColumnsConsistency(sheetAsArray, sheetNumber);

        checkRowsConsistency(sheetAsArray, sheetNumber);

        return sheetAsArray;
    }

    /**
     * On vérifie que les totaux de chaque ligne de formation sont cohérents sauf pour les autres origines (dernière ligne)
     *
     * @param sheetAsArray
     * @param sheetNumber
     * @throws HistoriqueException
     */
    private void checkRowsConsistency(final int[][] sheetAsArray, final int sheetNumber) throws HistoriqueException {

        for (int i = 0; i < sheetAsArray.length; i++) {
            final int[] currentRow = sheetAsArray[i];
            int effectifCount = 0;

            for (int j = 0; j < currentRow.length - 1; j++) {
                effectifCount += currentRow[j];
            }

            if (effectifCount != currentRow[currentRow.length - 1]) {
                throw new HistoriqueException("Erreur de cohérence des totaux dans l'onglet " + sheetNumber + " sur la ligne " + i + 1, sheetNumber);
            }
        }
    }

    /**
     * On vérifie que les totaux de chaque colonne de formation sont cohérents sauf pour les sorties (dernière colonne)
     *
     * @param sheetAsArray
     * @param sheetNumber
     * @throws HistoriqueException
     */
    private void checkColumnsConsistency(final int[][] sheetAsArray, final int sheetNumber) throws HistoriqueException {
        for (int i = 0; i < sheetAsArray[0].length - 2; i++) {

            int effectifCount = 0;

            for (int j = 0; j < sheetAsArray.length - 1; j++) {
                effectifCount += sheetAsArray[j][i];
            }

            if (effectifCount != sheetAsArray[sheetAsArray.length - 1][i]) {
                throw new HistoriqueException("Erreur de cohérence des totaux dans l'onglet " + sheetNumber + " sur la colonne " + i + 1, sheetNumber);
            }
        }
    }

    private int getCellIntValue(final XSSFCell cell) {
        return !StringUtils.isEmpty(cell.getRawValue()) ? Integer.parseInt(cell.getRawValue()) : 0;
    }

    private byte[] intArrayToBlob(final int[][][] data) {
        return null;
    }
}
