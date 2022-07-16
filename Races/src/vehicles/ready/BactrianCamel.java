package vehicles.ready;

import vehicles.GroundV;
import vehicles.TrackV;

public class BactrianCamel extends GroundV {
    public double Speed = 10;
    public double RestInterval = 30;
    public String name  = "BactrianCamel";

    @Override
    public double RestDuration(double count){
        return (count == 1 ? 5.0 : 8.0);
    }

    @Override
    public double Time(TrackV track) {
        double time=track.distance/Speed;
        for (double i=1, j = RestInterval; j< track.distance/Speed; i++, j+=RestInterval){
            time+=RestDuration(i);
        }
        return time;
    }

    @Override
    public String getName(){
        return name;
    }
}
