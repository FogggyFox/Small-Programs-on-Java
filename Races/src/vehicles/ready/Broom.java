package vehicles.ready;

import vehicles.AirV;
import vehicles.TrackV;



public class Broom extends AirV {
    public  double Speed  = 20;
    public  String name  = "Broom";

    @Override
    public double DistanceReducer(double distance) {
        return (double)((int)distance /1000)/100;
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
