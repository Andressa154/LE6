/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import S.S_Game;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andde
 */
public class csv {
    
    
    public static List<S_Game> readGameCsv(Path csvFilePath){

        List<S_Game> gameList = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<S_Game> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(S_Game.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            gameList = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameList;
    }
    
    
}
