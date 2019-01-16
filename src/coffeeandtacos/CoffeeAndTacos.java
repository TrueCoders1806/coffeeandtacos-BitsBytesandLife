package coffeeandtacos;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeAndTacos {

    public static void main(String[] args) {
        
        String path = "TacoBell-US-AL.csv";
        
        List<String> lines = new ArrayList<>();
        Scanner scanner; 
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
            }           
        } catch (Exception ex) {
            Logger.getLogger(CoffeeAndTacos.class.getName()).log(Level.SEVERE, null, ex);
        }  
        System.out.print(lines);
    }  
}
