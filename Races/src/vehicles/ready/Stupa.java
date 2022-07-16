package vehicles.ready;

import vehicles.AirV;
import vehicles.TrackV;

public class Stupa extends AirV {
    public  double Speed  = 8;
    public  String name  = "Stupa";

    @Override
    public double DistanceReducer(double distance) {
        return 0.06;
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
