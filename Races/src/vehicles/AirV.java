package vehicles;

public abstract class AirV implements IVehicle {

    protected double Speed;
    public abstract double DistanceReducer(double distance);



    public abstract double Time(TrackV track);


    @Override
    public abstract String getName();
}
