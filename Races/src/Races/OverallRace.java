package Races;

import Exceptions.EmptyRaceException;
import vehicles.IVehicle;
import vehicles.TrackV;

public class OverallRace extends Race<IVehicle> {
    public OverallRace(TrackV track) {
        super(track);
    }

    @Override
    public IVehicle Start() throws EmptyRaceException {
        return super.Start();
    }
}
