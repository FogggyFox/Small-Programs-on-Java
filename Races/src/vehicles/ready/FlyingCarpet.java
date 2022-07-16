package vehicles.ready;

import vehicles.AirV;
import vehicles.TrackV;

public class FlyingCarpet extends AirV {
    public  double Speed  = 10;
    public  String name  = "Flying Carpet";

    @Override
    public double DistanceReducer(double distance) {
        return distance < 1000 ? 0 : distance < 5000 ? 0.03 : distance < 10000 ? 0.1 : 0.05;
    }

    @Override
    public double Time(TrackV track) {
        return (track.distance*(1-DistanceReducer(track.distance))/Speed);
    }

    @Override
    public String getName(){
        return name;
    }
}
