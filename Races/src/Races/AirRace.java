package Races;

import Exceptions.EmptyRaceException;
import vehicles.AirV;
import vehicles.TrackV;

public class AirRace extends Race<AirV> {
    public AirRace(TrackV track) {
        super(track);
    }

    @Override
    public AirV Start() throws EmptyRaceException {
        return super.Start();
    }
}
