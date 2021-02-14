package factory;

import model.Bike;
import model.Car;
import model.Truck;
import model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {

    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public VehicleFactory() {
        vehicleMap.put("Car", new Car());
        vehicleMap.put("Truck", new Truck());
        vehicleMap.put("Bike", new Bike());
    }

    public Vehicle getVehicle(String vehicle) {
        return vehicleMap.getOrDefault(vehicle, null);
    }

}
