package Races;

import Exceptions.EmptyRaceException;
import vehicles.IVehicle;
import vehicles.TrackV;

import java.util.ArrayList;
import java.util.List;

public abstract class Race<T extends IVehicle>{
    public TrackV track;
    private List<T> registredVehicles = new ArrayList<>();

    public Race(TrackV track){
        this.track=track;
    }
    public void RegVehicle(T vehicle){
        registredVehicles.add(vehicle);
    }
    public T Start() throws EmptyRaceException {
        if (registredVehicles.size() == 0) throw new EmptyRaceException("There are no vehicles in Race!");
        double min = Double.MAX_VALUE;
        T veh= null;

        for ( T item : registredVehicles){
            double time=item.Time(track);
            if (time < min){
                min=time;
                veh=item;
            }
        }
        return veh;
    }

}
