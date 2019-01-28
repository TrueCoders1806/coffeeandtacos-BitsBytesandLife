package coffeeandtacos;

import java.io.*;
import java.util.*;

public class CoffeeAndTacos {

    private static ILog logger = new TacoLogger();
    private static final String PATH = "TacoBell-US-AL.csv";
    
    public static void main(String[] args) {
          
        List<Trackable> locations = new ArrayList<>();
        logger.logInfo("Begin Parsing");
        var parser = new TacoParser();
        Scanner scanner;      
        try {
            scanner = new Scanner(new File(PATH));
            while (scanner.hasNextLine()) {
            locations.add(parser.Parse(scanner.nextLine()));
            }           
        } catch (Exception e) {
            logger.logSevere("Cannot find file path", e);
        }  
        logger.logInfo("File Parsed");
        // TODO:  Find the two Taco Bells in Alabama that are the furthest from one another.
        // HINT:  You'll need two nested forloops
        
        Trackable locA = null;
        Trackable locB = null;
            //Trackable locA = null;
            //Trackable locB = null;
            double distance = 0;
            
            for (Trackable strartingTacoBellLocation : locations){
                //var origin = locA.getLocation().getLatitude();
                // Creating a new Coordinate with locations locA lat and long
                //var origin = new GeoCoordinate(locations[i].Location.Latitude, locations[i].Location.Longitude);
                var origin = new GeoCoordinate(strartingTacoBellLocation.getLocation().getLatitude(),
                                               strartingTacoBellLocation.getLocation().getLongitude());
                for (Trackable endindTacoBellLocation : locations){
                    var destination = new GeoCoordinate(endindTacoBellLocation.getLocation().getLatitude(),
                                               endindTacoBellLocation.getLocation().getLongitude());
                    var currentDistance = origin.getDistanceTo(destination);
                    if (currentDistance > distance)
                    {
                        distance = currentDistance;
                        locA = strartingTacoBellLocation;
                        locB = endindTacoBellLocation;
                    }
                }
                //logger.logInfo("File Parsed");
                logger.logInfo("\nStarting Taco Bell:" + locA.getName() + "\nEnding Taco Bell:" + locB.getName() +  
                               "\nDistance:" + distance + " miles.");
            }
    }  
}
