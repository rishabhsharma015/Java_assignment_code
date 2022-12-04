import java.util.ArrayList;
import java.util.Scanner;

public class ParkingLot {
    private int noOfFloors;
    private String parkingLotName;
    private ArrayList<Floor> Floors = new ArrayList<>();
    private int amountForCar;
    private int amountForTruck;
    private int amountForVan;
    private int amountForMotorcycle;

    public ParkingLot(){
        this.amountForCar = 0;
        this.amountForTruck = 0;
        this.amountForVan = 0;
        this.amountForMotorcycle = 0;
    }


    public ParkingLot(String parkingLotName){
        this.parkingLotName = parkingLotName;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public ArrayList<Floor> getFloors() {
        return Floors;
    }

    public ArrayList<AvailableFloorSpotInfo> infoObjList = new ArrayList<>();

    private ArrayList<Ticket_Information> ticketInfoList = new ArrayList<>();



    public boolean addFloor(Floor floor){
        if(floor.isFloorAvailable(floor.getFloorNumber(), Floors)){
            return false;
        }
        Floors.add(floor);
        noOfFloors++;
        return true;
    }


    // Method to remove the floor
    public String removeFloor(Floor floor){
        if(floor.isFloorAvailable(floor.getFloorNumber(), Floors)){
            Floors.remove(floor);
            noOfFloors--;
            return "Floor number "+floor.getFloorNumber()+" is removed temporarily from available parking floor list.";
        }
        return "Invalid floor number";
    }


    // Method to show the floors available for parking.
    public void showAvailableFloor(){
        System.out.print("Following are the available floors for parking -> ");
        for(Floor f:Floors){
            System.out.print(f.getFloorNumber()+" ");
        }
    }


    // This method is used to check the availability for the vehicle to be parked based on the spotSize.
    public AvailableFloorSpotInfo checkSpecificSpotOnFloors(int spotSize) {
        for(Floor floor: Floors){
            ArrayList<Spot> spots = floor.getSpots();
            for(int spotidx=0; spotidx<spots.size(); spotidx++){
                if(spots.get(spotidx).spotSize == spotSize && spots.get(spotidx).spotState!='O'){

                    System.out.println("We have an availability to park your vehicle");
                    System.out.println("Enter your vehicle number please.");

                    int vehicleNumber = new Scanner(System.in).nextInt();

                    System.out.println("Generated ticket"+"\n| 1) Floor number: "+floor.getFloorNumber()+" |\n| 2) Spot location: "+spotidx+"|");
                    System.out.println();
                    System.out.println("Keep this ticket, will be required for un-parking the vehicle");
                    Ticket_Information userTicketInfo = new Ticket_Information(floor, spotidx, vehicleNumber);
                    ticketInfoList.add(userTicketInfo);   // This will help us in un-parking process.
                    spots.get(spotidx).setSpotState('O');
                    AvailableFloorSpotInfo infoObj = new AvailableFloorSpotInfo(floor, spotidx);

                    infoObjList.add(infoObj);
                    return infoObj;            // returning available floor and spotLocation on it.
                }
            }
        }
        System.out.println("Sorry for the inconvenience, Parking Lot is full. You can not park your vehicle.");
        return new AvailableFloorSpotInfo(new Floor(), -1);   // returning a spot that does not exist.
    }


    // This method is to un-park the parked vehicles.
    public void unParking(int spotIdx, int vehicleNumber){
        for(Floor floor: getFloors()){
            if(floor.getSpots().get(spotIdx).spotState == 'O'){
                for (Ticket_Information userTicketInformation: ticketInfoList) {
                    if(userTicketInformation.getSpotIdx() == spotIdx && userTicketInformation.getVehicleNumber() == vehicleNumber){
                        System.out.println("Verification done, you can now un-park your vehicle by paying the amount.");
                        floor.getSpots().get(spotIdx).setSpotState('U');
                        if(spotIdx>=0 && spotIdx<40){
                            // Amount paid by user.
                            this.amountForCar+=30;
                            floor.setUnoccupiedSpots(floor.getUnoccupiedSpots() + 1);
                            floor.setOccupiedSpots(floor.getOccupiedSpots() - 1);
                            floor.setNoOfCompactSpots(floor.getNoOfCompactSpots() + 1);
                            System.out.println(amountForCar);
                        }
                        else if(spotIdx>=40 && spotIdx<65){
                            // Amount paid by user.
                            this.amountForTruck+=50;
                            floor.setUnoccupiedSpots(floor.getUnoccupiedSpots() + 1);
                            floor.setOccupiedSpots(floor.getOccupiedSpots() - 1);
                            floor.setNoOfLargeSpots(floor.getNoOfLargeSpots() + 1);
                        }
                        else if(spotIdx>=65 && spotIdx<85){
                            // Amount paid by user.
                            this.amountForVan+=40;
                            floor.setUnoccupiedSpots(floor.getUnoccupiedSpots() + 1);
                            floor.setOccupiedSpots(floor.getOccupiedSpots() - 1);
                            floor.setNoOfHandiCapSpots(floor.getNoOfHandiCapSpots() + 1);
                        }
                        else if(spotIdx>=85 && spotIdx<100){
                            // Amount paid by user.
                            this.amountForMotorcycle+=10;
                            floor.setUnoccupiedSpots(floor.getUnoccupiedSpots() + 1);
                            floor.setOccupiedSpots(floor.getOccupiedSpots() - 1);
                            floor.setNoOfMotorCycleSpots(floor.getNoOfMotorCycleSpots() + 1);
                        }
                    }

                    else{
                        System.out.println("Invalid spot location, you cannot un-park your vehicle");
                    }
                }

                for(Spot spots:floor.getSpots()){
                    System.out.print(spots.spotState+" ");
                }
            }

            else{
                System.out.println("Invalid spot location, spot is unoccupied");
            }

        }

    }

}
