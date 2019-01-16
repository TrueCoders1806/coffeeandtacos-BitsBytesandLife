package coffeeandtacos;

/// Parses a POI file to locate all the Taco Bells
public class TacoParser {
    
    public ILog logger = new TacoLogger();
    
    public Trackable Parse(String line) {
        
        logger.logInfo("Begin Parsing");
        
        // Do not fail if one record parsing fails, return null
        return null; //TODO Implement
    }
}
