package coffeeandtacos;

public class TacoParser {
    
    public ILog logger = new TacoLogger();
    
    public Trackable Parse(String line) {
        
        if(line == null){
            logger.logWarning("Line was null");
            return null;
        }
        
        var cells = line.split(",");
        
        if (cells.length > 3 ){
            logger.logWarning("The length was the array less than 3");
            return null;
        }
        
        var tacoBellLocation = new Trackable();
        var tacoBellLocationPoint = new Point();
        
        try {    
            tacoBellLocationPoint.setLatitude(Double.parseDouble(cells[0]));
        }
        catch (Exception e) {
            logger.logWarning("Not a Number", e);
            return null;
        }
        if (tacoBellLocationPoint.getLatitude() < -90 || tacoBellLocationPoint.getLatitude() > 90) {
            logger.logWarning("Not a Valid Latitude.");
            return null;
        }
        
        try {
          tacoBellLocationPoint.setLongitude(Double.parseDouble(cells[1]));
        }
        catch (Exception e) {
           logger.logWarning("Not a Number", e);
           return null;
        }
        if (tacoBellLocationPoint.getLongitude() < -180 || tacoBellLocationPoint.getLongitude() > 180) {
           logger.logWarning("Not a Valid Longitude");
           return null;
        }
        
        var name = cells[2].trim();
        
        if (name.length() < 9) {
          logger.logWarning("Not a Valid location");
          return null;
        }
        
        if (!name.contains("Taco Bell")) {
          logger.logWarning("Not a Valid Taco Bell");
          return null;
        }
        tacoBellLocation.setName(name.replace("Taco Bell", "").replace("... (Free trial * Add to Cart for a full POI info)", "").replace("/", "").trim());
        tacoBellLocation.setLocation(tacoBellLocationPoint);
       
        return tacoBellLocation; 
    }
}
