package model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Integer, ParkingSlot> parkingSlot;
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        this.parkingSlot = new HashMap<>();
    }

    public Map<Integer, ParkingSlot> getParkingSlot() {
        return parkingSlot;
    }

    public ParkingSlot getSlot(Integer slotNumber) {
        if (slotNumber > getCapacity() || slotNumber <= 0) {
            throw new RuntimeException("invalid number");
        }
        if (parkingSlot.containsKey(slotNumber)) {
            return parkingSlot.get(slotNumber);
        }
        ParkingSlot newSlot = new ParkingSlot(slotNumber);
        parkingSlot.put(slotNumber, newSlot);
        return parkingSlot.get(slotNumber);
    }

    public ParkingSlot parkCar(Integer slotNumber, Vehicle vehicle) {
        ParkingSlot slot = getSlot(slotNumber);
        if (!slot.isSlotFree()) {
            throw new RuntimeException("slot full");
        }
        slot.setVehicle(vehicle);
        return slot;
    }

    public Integer removeCar(Integer slotNumber, Integer exitTime) {
        ParkingSlot slot = getSlot(slotNumber);
        Vehicle vehicle = slot.getVehicle();
        vehicle.setExitTime(exitTime);
        Integer fees = vehicle.calculateCharges();
        slot.emptySlot();
        return fees;
    }


}
