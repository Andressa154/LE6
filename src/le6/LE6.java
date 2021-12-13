/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le6;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import le6.model.Publisher;
import le6.model.Platform;
import le6.model.Game;


/**
 *
 * @author andde
 */
public class LE6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Path caminho = null;
        try {
            caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<Game> gameList = CsvUtils.readGameCsv(caminho);


        int numLines = gameList.size();
        System.out.println("Numero de linhas: " + numLines);

        List<Game> ps4Games = ServiceGame.getListByPlatform(gameList, Platform.PS4);

        System.out.println("Numero de jogos de ps4: " + ps4Games.size());
        ps4Games.forEach(e -> System.out.println(e.getName()));
        System.out.println("");
        List<Game> activisionGames = ServiceGame.getByPuBlisher(gameList, Publisher.Activision);
        System.out.println("Numero de jogos da activision: " + activisionGames.size());
        activisionGames.forEach(e -> System.out.println(e.getName()));
        
    }
    
}
