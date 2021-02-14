import enums.CarType;
import factory.VehicleFactory;
import model.Car;
import model.ParkingLot;
import model.Vehicle;
import service.ParkingLotService;
import strategy.ClosestFirstStrategy;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws IOException {
        ParkingLot parkingLot = new ParkingLot(100);
        ClosestFirstStrategy closestFirstStrategy = new ClosestFirstStrategy();
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.createParkingLot(parkingLot, closestFirstStrategy);
        VehicleFactory vehicleFactory = new VehicleFactory();
        while(true) {
            System.out.println("1. Park a Vehicle");
            System.out.println("2. Free a Slot");
            System.out.println("3. Get all vehicles in parking");
            System.out.println("4. Exit");
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            int input = sc.nextInt();
            switch(input) {
                case 1:
                    System.out.println("1. Car");
                    System.out.println("2. Truck");
                    System.out.println("3. Bike");
                    String vehicleType = sc2.nextLine();
                    Vehicle vehicle = vehicleFactory.getVehicle(vehicleType);
                    if (vehicle == null) {
                        throw new RuntimeException("Incorrect Type");
                    }
                    System.out.println("Enter Reg Number: ");
                    String regNumber = sc2.nextLine();
                    vehicle.setRegNumber(regNumber);
                    System.out.println("Enter Entry Time: ");
                    Integer entryTime = sc.nextInt();
                    vehicle.setEntryTime(entryTime);
                    parkingLotService.park(vehicle);
                    break;
                case 2:
                    System.out.println("Enter Slot number to free ");
                    int slotNumber = sc.nextInt();
                    System.out.println("Enter Exit Time ");
                    Integer exitTime = sc.nextInt();
                    Integer charges = parkingLotService.makeSlotFree(slotNumber, exitTime);
                    System.out.println("Charges: " + charges);
                    break;
                case 3:
                    parkingLotService.showAllSlots();
                    break;
                case 4:
                    return;
            }
        }
    }
}
