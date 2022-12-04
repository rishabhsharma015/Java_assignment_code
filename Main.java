import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot("ABC Parking Lot");       // Parking lot created
        Floor floor0 = new Floor(0, 100);                         // One floor added in parking lot.
        parkingLot.addFloor(floor0);


        AvailableFloorSpotInfo infoObj;

        while (true) {
            System.out.println("Welcome to " + parkingLot.getParkingLotName() + "\nSelect \n1) Parking\n2)Un-parking \nBy pressing 1 or 2 respectively ");
            int choice = sc.nextInt();


            // Parking
            if (choice == 1) {
                System.out.print("Welcome to " + parkingLot.getParkingLotName() + "\nSelect your vehicle from the given choices\n(Car / Truck / Handicap-vehicle / Motorcycle / Electric-Vehicle) \nBy pressing (1/2/3/4/5) respectively.");
                System.out.println("\nIf you want to quit, press 0 please");

                int spotSize = sc.nextInt();
                if (spotSize == 1) {     // Compact vehicles.
                    infoObj = parkingLot.checkSpecificSpotOnFloors(spotSize);
                    if (infoObj.spotIdx != -1) {
                        Floor floorOfAvailableSpot = infoObj.floor;
                        floorOfAvailableSpot.setUnoccupiedSpots(floorOfAvailableSpot.getUnoccupiedSpots() - 1);
                        floorOfAvailableSpot.setOccupiedSpots(floorOfAvailableSpot.getOccupiedSpots() + 1);
                        floorOfAvailableSpot.setNoOfCompactSpots(floorOfAvailableSpot.getNoOfCompactSpots() - 1);
//                        System.out.println(floorOfAvailableSpot.getFloorInfo(floorOfAvailableSpot, parkingLot.getFloors()));
//                        for (Spot spots : floorOfAvailableSpot.getSpots()) {
//                            System.out.print(spots.spotState + " ");
//                        }
                    }
                } else if (spotSize == 2) { // Large Vehicles.
                    infoObj = parkingLot.checkSpecificSpotOnFloors(spotSize);
                    if (infoObj.spotIdx != -1) {
                        Floor floorOfAvailableSpot = infoObj.floor;
                        floorOfAvailableSpot.setUnoccupiedSpots(floorOfAvailableSpot.getUnoccupiedSpots() - 1);
                        floorOfAvailableSpot.setOccupiedSpots(floorOfAvailableSpot.getOccupiedSpots() + 1);
                        floorOfAvailableSpot.setNoOfLargeSpots(floorOfAvailableSpot.getNoOfLargeSpots() - 1);
                    }
                } else if (spotSize == 3) {   // Handicap Vehicles.
                    infoObj = parkingLot.checkSpecificSpotOnFloors(spotSize);
                    if (infoObj.spotIdx != -1) {
                        Floor floorOfAvailableSpot = infoObj.floor;
                        floorOfAvailableSpot.setUnoccupiedSpots(floorOfAvailableSpot.getUnoccupiedSpots() - 1);
                        floorOfAvailableSpot.setOccupiedSpots(floorOfAvailableSpot.getOccupiedSpots() + 1);
                        floorOfAvailableSpot.setNoOfHandiCapSpots(floorOfAvailableSpot.getNoOfHandiCapSpots() - 1);
                    }
                } else if (spotSize == 4) {    // Motorcycles.
                    infoObj = parkingLot.checkSpecificSpotOnFloors(spotSize);
                    if (infoObj.spotIdx != -1) {
                        Floor floorOfAvailableSpot = infoObj.floor;
                        floorOfAvailableSpot.setUnoccupiedSpots(floorOfAvailableSpot.getUnoccupiedSpots() - 1);
                        floorOfAvailableSpot.setOccupiedSpots(floorOfAvailableSpot.getOccupiedSpots() + 1);
                        floorOfAvailableSpot.setNoOfMotorCycleSpots(floorOfAvailableSpot.getNoOfMotorCycleSpots() - 1);
                    }
                }
                else if(spotSize==5){   // Electric vehicles.
                    infoObj = parkingLot.checkSpecificSpotOnFloors(spotSize);
                    if (infoObj.spotIdx != -1) {
                        Floor floorOfAvailableSpot = infoObj.floor;
                        floorOfAvailableSpot.setUnoccupiedSpots(floorOfAvailableSpot.getUnoccupiedSpots() - 1);
                        floorOfAvailableSpot.setOccupiedSpots(floorOfAvailableSpot.getOccupiedSpots() + 1);
                        floorOfAvailableSpot.setNoOfElectricVehicleSpots(floorOfAvailableSpot.getNoOfElectricVehicleSpots() - 1);
                    }
                }

                else {  // Invalid choice.
                    System.out.println("Invalid Selection of vehicle");
                }

            }

            // Un-Parking.
            else if (choice == 2) {
                System.out.println("To un-park your vehicle kindly enter the details");
                System.out.println("1) Enter your vehicle number");
                int vehNum = sc.nextInt();
                System.out.println("1) Enter your vehicle spot number");
                int spotIdx = sc.nextInt();


                // Verifying..


                parkingLot.unParking(spotIdx, vehNum);

            }

            // Invalid choice.
            else {
                break;
            }


        }

    }


}
