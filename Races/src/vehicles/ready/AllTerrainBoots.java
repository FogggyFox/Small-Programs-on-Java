package vehicles.ready;

import vehicles.GroundV;
import vehicles.TrackV;




public class AllTerrainBoots extends GroundV {
    public double Speed = 6;
    public double RestInterval = 60;
    public String name  = "AllTerrainBoots";

    @Override
    public double RestDuration(double count){
        return (count == 1 ? 10.0 : 5.0);
    }
    @Override
    public double Time(TrackV track){
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
