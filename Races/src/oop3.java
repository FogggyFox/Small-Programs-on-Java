import Exceptions.DistanceException;
import Exceptions.EmptyRaceException;
import Races.*;
import vehicles.IVehicle;
import vehicles.TrackV;
import vehicles.ready.*;

import java.util.Scanner;

public class oop3 {
    public static void main(String[] args) {
        System.out.println("If you want overall race - type 1. If you want air race type 2. \nIf you want ground race - type 3.");
        Scanner in = new Scanner(System.in);
        int choice= in.nextInt();
        System.out.println("Write your distance:");
        double dist = in.nextDouble();
        try {
            TrackV track = new TrackV(dist);
        } catch (DistanceException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return;
        }
        switch (choice){
            case (1):
                try{
                    TrackV track = new TrackV(dist);
                    OverallRace race = new OverallRace(track);
                    race.RegVehicle(new AllTerrainBoots());
                    race.RegVehicle(new BactrianCamel());
                    race.RegVehicle(new SpeedyCamel());
                    race.RegVehicle(new Centaur());
                    race.RegVehicle(new Broom());
                    race.RegVehicle(new FlyingCarpet());
                    race.RegVehicle(new Stupa());
                    IVehicle winner = race.Start();
                    System.out.println("The winner of overall race on " + dist + " distance: " + winner.getName());
                } catch (EmptyRaceException | DistanceException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case (2):
                try{
                    TrackV track = new TrackV(dist);
                    AirRace race = new AirRace(track);
                    race.RegVehicle(new Broom());
                    race.RegVehicle(new FlyingCarpet());
                    race.RegVehicle(new Stupa());
                    IVehicle winner = race.Start();
                    System.out.println("The winner of air race on " + dist + " distance: " + winner.getName());
                } catch (EmptyRaceException | DistanceException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case (3):
                try{
                    TrackV track = new TrackV(dist);
                    GroundRace race = new GroundRace(track);
                    race.RegVehicle(new AllTerrainBoots());
                    race.RegVehicle(new BactrianCamel());
                    race.RegVehicle(new SpeedyCamel());
                    race.RegVehicle(new Centaur());
                    IVehicle winner = race.Start();
                    System.out.println("The winner of ground race on " + dist + " distance: " + winner.getName());
                } catch (EmptyRaceException | DistanceException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Wrong imput. Quitting");
                System.exit(1);
                return;
        }
        System.exit(0);
        return;
    }
}
