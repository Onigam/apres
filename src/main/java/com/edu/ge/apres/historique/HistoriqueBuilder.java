package com.edu.ge.apres.historique;

import com.edu.ge.apres.domain.Historique;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;

@Service
public class HistoriqueBuilder {

    public Historique importDataToHistorique(InputStream is, Historique historique) throws IOException, BiffException, HistoriqueException {

        int [][][] data = parseSheets(is, historique);
        historique.setData(intArrayToBlob(data));
        return historique;
    }

    private int[][][] parseSheets(InputStream is, Historique historique) throws IOException, BiffException, HistoriqueException {

        Workbook excelParser = Workbook.getWorkbook(is);
        Sheet[] sheets = excelParser.getSheets();
        int nbSheet = historique.getAnneeFin() - historique.getAnneeDebut();
        int[][][] result = new int[nbSheet][][];
        int stopSheet = (nbSheet <= sheets.length - 1) ? nbSheet : sheets.length - 1;

        // Lister chaque année en un tableau de 2 dimensions
        for (int i = 0; i< stopSheet; i++) {
            // Vérifier la cohérence des données
            result[i] = parseSheet(sheets[i]);
        }

        return result;
    }

    private int[][] parseSheet(Sheet sheet) throws IOException, BiffException, HistoriqueException {

        int nbFormations = sheet.getRows() - 2;

        // Pour chaque année tester si la valeur de la dernière ligne est égale a la somme des éléments jusqu'a i - 1
        for(int i = 1; i < sheet.getColumns() - 2; i++) {
            if (isColumnValid(sheet, i, nbFormations));
        }

        return null;
    }

    private boolean isColumnValid(Sheet sheet, int column, int nbFormations) {

        int effectifTotal = Integer.parseInt(sheet.getCell(column, nbFormations + 1).getContents());
        int effectifCount = 0;

        for (int i = 1; i < nbFormations; i++) {
            effectifCount += getCellIntValue(sheet.getCell(column, i));
        }

        return effectifCount == effectifTotal;
    }

    private int getCellIntValue(Cell cell) {
        return !StringUtils.isEmpty(cell.getContents()) ? Integer.parseInt(cell.getContents()) : 0;
    }

    private byte[] intArrayToBlob(int [][][] data) {
        return null;
    }
}
