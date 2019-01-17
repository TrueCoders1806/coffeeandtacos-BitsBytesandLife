package coffeeandtacos;

/// Parses a POI file to locate all the Taco Bells
public class TacoParser {
    
    public ILog logger = new TacoLogger();
    
    public Trackable Parse(String line) {
        
        logger.logInfo("Begin Parsing");
        if(line == null)
            {
                logger.logWarning("Line was null");
                return null;
            }
        // Take your line and use line.Split(',') to split it up into an array of strings, separated by the char ','
        var cells = line.split(",");
        
        // Do not fail if one record parsing fails, return null
        // If your array.Length is less than 3, something went wrong
        if (cells.length < 3 || cells.length > 3)
        {
            // Log that and return null
            logger.logWarning("The length was the array less than 3");
            return null;
        }
        
        var tacoBellLocation = new Trackable();
        var tacoBellLocationPoint = new Point();
        
        // grab the latitude from your array at index 0
        // tacoBellLocationPoint.latitude = convert.ToDouble(cells[0]);
        tacoBellLocationPoint.setLatitude(Double.parseDouble(cells[0]));
        tacoBellLocationPoint.setLongitude(Double.parseDouble(cells[1]));
        
        var name = cells[2].trim();
        
        tacoBellLocation.setName(name);
        tacoBellLocation.setLocation(tacoBellLocationPoint);
       
            
        // Do not fail if one record parsing fails, return null
        return tacoBellLocation; //TODO Implement
    }
}
