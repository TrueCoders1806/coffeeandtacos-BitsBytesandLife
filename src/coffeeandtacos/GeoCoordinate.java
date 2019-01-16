package coffeeandtacos;

public class GeoCoordinate {
    
    private Point point = new Point();
    
    public GeoCoordinate(double lat, double lon) {
        point.setLatitude(lat);
        point.setLongitude(lon);
    }
    
    public double getDistanceTo(GeoCoordinate geo) {
	if ((this.point.getLatitude() == geo.point.getLatitude()) && (this.point.getLongitude() == geo.point.getLongitude())) {
            return 0;
	}
	else {
            double theta = this.point.getLongitude() - geo.point.getLongitude();
            double dist = Math.sin(Math.toRadians(this.point.getLatitude())) * 
                    Math.sin(Math.toRadians(geo.point.getLatitude())) + 
                    Math.cos(Math.toRadians(this.point.getLatitude())) * 
                    Math.cos(Math.toRadians(geo.point.getLatitude())) * 
                    Math.cos(Math.toRadians(theta));
            
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
          
            return (dist);
        }
    }
}
