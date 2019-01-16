package coffeeandtacos;

import java.io.*;
import java.util.*;

public class CoffeeAndTacos {

    private static ILog logger = new TacoLogger();
    private static final String PATH = "TacoBell-US-AL.csv";
    
    public static void main(String[] args) {
          
        List<Trackable> lines = new ArrayList<>();
        var parser = new TacoParser();
        Scanner scanner;      
        try {
            scanner = new Scanner(new File(PATH));
            while (scanner.hasNextLine()) {
            lines.add(parser.Parse(scanner.nextLine()));
            }           
        } catch (Exception e) {
            logger.logSevere("Cannot find file path", e);
        }  
        
        // TODO:  Find the two Taco Bells in Alabama that are the furthest from one another.
        // HINT:  You'll need two nested forloops
        
    }  
}
