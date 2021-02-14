package service;

import model.ParkingLot;
import model.ParkingSlot;
import model.Vehicle;
import strategy.ParkingStrategy;

import java.util.Map;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(Vehicle vehicle) {
        Integer nextFreeSlot = parkingStrategy.getNextFreeSlot();
        parkingLot.parkCar(nextFreeSlot, vehicle);
        parkingStrategy.removeSlot(nextFreeSlot);
        System.out.println(nextFreeSlot);
        return nextFreeSlot;
    }

    public Integer makeSlotFree(Integer slotNumber, Integer exitTime) {
        Integer fees = parkingLot.removeCar(slotNumber, exitTime);
        parkingStrategy.addSlot(slotNumber);
        return fees;
    }

    public void showAllSlots() {
        Map<Integer, ParkingSlot> parkingSlotMap = parkingLot.getParkingSlot();
        for (int i = 1 ; i < parkingLot.getCapacity() ; i++) {
            if (parkingSlotMap.get(i) != null && !parkingSlotMap.get(i).isSlotFree()) {
                ParkingSlot slot = parkingSlotMap.get(i);
                System.out.println("Vehicle Type: " + slot.getVehicle().getVehicleType() + " Vehicle Reg Number: " + slot.getVehicle().getRegNumber() + " Slot Number: " + slot.getSlotNumber());
            }
        }
    }

}
