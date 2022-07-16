package Races;

import Exceptions.EmptyRaceException;
import vehicles.GroundV;
import vehicles.TrackV;

public class GroundRace extends Race<GroundV> {
    public GroundRace(TrackV track) {
        super(track);
    }

    @Override
    public GroundV Start() throws EmptyRaceException {
        return super.Start();
    }
}
