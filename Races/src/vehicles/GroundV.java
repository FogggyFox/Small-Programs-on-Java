package vehicles;

public abstract class GroundV implements IVehicle {
    protected double Speed;
    protected double RestInterval;
    public abstract double RestDuration(double count);


    public abstract double Time(TrackV track);

    public abstract String getName();
}
