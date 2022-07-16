package vehicles;

import Exceptions.DistanceException;

public class TrackV {
    public double distance;
    public TrackV(double distance) throws DistanceException {
        if (distance<=0) {
            throw new DistanceException("Distance can't be below or equal 0");
        }
        else{
            this.distance=distance;
        }
    }
}
