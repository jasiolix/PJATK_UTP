package Task1_TableOfCountries.src.src.zad1;

import javax.swing.*;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

class CountryTable {
    private String countriesFileName;
    public CountryTable(String countriesFileName) {
        this.countriesFileName = countriesFileName;
    }

    public JTable create() throws Exception{
        JTable table;
        String iFileName = countriesFileName;
        Path fileIn =  Paths.get(iFileName);

        BufferedReader brCount = Files.newBufferedReader(fileIn, UTF_8);
        int noOfLines=0;
        while(brCount.readLine() != null)
            noOfLines++;
        brCount.close();

        BufferedReader br = Files.newBufferedReader(fileIn, UTF_8);
        br = Files.newBufferedReader(fileIn, UTF_8);
        String[] colNames = br.readLine().split("\\t");
        Object[][] data = new String[noOfLines-1][3];
        for(int i=0;i<noOfLines-1;i++)
            data[i] = br.readLine().split("\\t");
        br.close();

        table = new JTable(data, colNames);
        return table;
    }
}
