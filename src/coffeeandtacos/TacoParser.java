package coffeeandtacos;

/// Parses a POI file to locate all the Taco Bells
public class TacoParser {
    
    public ILog logger = new TacoLogger();
    
    public Trackable Parse(String line) {
        
        if(line == null)
            {
                logger.logWarning("Line was null");
                return null;
            }
        // Take your line and use line.Split(',') to split it up into an array of strings, separated by the char ','
        var cells = line.split(",");
        
        // Do not fail if one record parsing fails, return null
        // If your array.Length is less than 3, something went wrong
        if (cells.length > 3 ) 
        {
            // Log that and return null
            logger.logWarning("The length was the array less than 3");
            return null;
        }
        
        var tacoBellLocation = new Trackable();
        var tacoBellLocationPoint = new Point();
        
       //grab the latitude from your array at index 0
       //validate the latitude if not log the error
        try
        {    
           tacoBellLocationPoint.setLatitude(Double.parseDouble(cells[0]));
        }
        catch (Exception e)
        {
            logger.logWarning("Not a Number", e);
            return null;
        }
        if (tacoBellLocationPoint.getLatitude() < -90 || tacoBellLocationPoint.getLatitude() > 90)
        {
            logger.logWarning("Not a Valid Latitude.");
            return null;
        }
        // grab the longitude from your array at index 1
        // validate the longitude if not log the error
        try
        {
          tacoBellLocationPoint.setLongitude(Double.parseDouble(cells[1]));
        }
        catch (Exception e)
        {
           logger.logWarning("Not a Number", e);
           return null;
        }
        if (tacoBellLocationPoint.getLongitude() < -180 || tacoBellLocationPoint.getLongitude() > 180)
        {
           logger.logWarning("Not a Valid Longitude");
           return null;
        }
        // grab the name from your array at index 2
        // validate the name if not log the error
        var name = cells[2].trim();
        
       
        // if (name.length < 9 || name.Substring(0, 9) != "Taco Bell")
        if (name.length() < 9)
        {
          logger.logWarning("Not a Valid location");
          return null;
        }
        
        if (!name.contains("Taco Bell"))
        {
          logger.logWarning("Not a Valid Taco Bell");
          return null;
        }
        tacoBellLocation.setName(name.replace("Taco Bell", "").replace("... (Free trial * Add to Cart for a full POI info)", "").replace("/", "").trim());
        tacoBellLocation.setLocation(tacoBellLocationPoint);
       
            
        // Do not fail if one record parsing fails, return null
        return tacoBellLocation; 
    }
}
