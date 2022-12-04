import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class Floor {
    private ArrayList<Spot> spots = new ArrayList<>();
    private int floorNumber;
    private int noOfSpots;
    private int occupiedSpots;
    private int unoccupiedSpots;
    private int noOfCompactSpots;
    private int noOfElectricVehicleSpots;
    private int noOfLargeSpots;
    private int noOfHandiCapSpots;
    private int noOfMotorCycleSpots;

    private ArrayList<Integer> fNos = new ArrayList<>();



    // Constructor to set the capacity and floor number of the floor.
    public Floor(int floorNumber, int noOfSpots){
        this.floorNumber = floorNumber;
        this.noOfSpots = noOfSpots;
        this.noOfCompactSpots = 30;
        this.noOfElectricVehicleSpots = 10;
        this.noOfLargeSpots = 25;
        this.noOfHandiCapSpots = 20;
        this.noOfMotorCycleSpots = 15;
        this.occupiedSpots = 0;
        this.unoccupiedSpots = noOfSpots - occupiedSpots;


        // adding different spots in arraylist.
        for(int i=0;i<30;i++){
            spots.add(new Compact());
        }
        for(int i=30;i<40;i++){
            spots.add(new ElectricVehicle());
        }
        for(int i=40;i<65;i++){
            spots.add(new Large());
        }
        for(int i=65;i<85;i++){
            spots.add(new Handicapped());
        }
        for(int i=85;i<100;i++){
            spots.add(new Motorcycle());
        }
    }

    // Default constructor.
    public Floor(){}



    // Getters & Setters
    public ArrayList<Spot> getSpots() {
        return this.spots;
    }

    public int getNoOfCompactSpots() {
        return this.noOfCompactSpots;
    }

    public int getNoOfLargeSpots() {
        return this.noOfLargeSpots;
    }

    public int getNoOfHandiCapSpots() {
        return this.noOfHandiCapSpots;
    }

    public int getNoOfMotorCycleSpots() {
        return this.noOfMotorCycleSpots;
    }

    public void setNoOfCompactSpots(int noOfCompactSpots) {
        this.noOfCompactSpots = noOfCompactSpots;
    }

    public void setNoOfLargeSpots(int noOfLargeSpots) {
        this.noOfLargeSpots = noOfLargeSpots;
    }

    public void setNoOfHandiCapSpots(int noOfHandiCapSpots) {
        this.noOfHandiCapSpots = noOfHandiCapSpots;
    }

    public void setNoOfMotorCycleSpots(int noOfMotorCycleSpots) {
        this.noOfMotorCycleSpots = noOfMotorCycleSpots;
    }

    public int getNoOfElectricVehicleSpots() {
        return noOfElectricVehicleSpots;
    }

    public void setNoOfElectricVehicleSpots(int noOfElectricVehicleSpots) {
        this.noOfElectricVehicleSpots = noOfElectricVehicleSpots;
    }

    // return the total number of spots.
    public int getNoOfSpots() {
        return this.noOfSpots;
    }

    // return the floor number of the floor.
    public int getFloorNumber() {
        return this.floorNumber;
    }

    // Number of spots available on the floor.
    public int getUnoccupiedSpots(){
        this.unoccupiedSpots = this.getNoOfSpots() - this.getOccupiedSpots();
        return unoccupiedSpots;
    }

    // Number of occupied spots.
    public int getOccupiedSpots() {
        return this.occupiedSpots;
    }

    // It sets the number of occupied spots.
    public void setOccupiedSpots(int occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
    }

    // It sets the the unoccupied spots.
    public void setUnoccupiedSpots(int unoccupiedSpots) {
        this.unoccupiedSpots = unoccupiedSpots;
    }



    // It will return the full info of the floor.
    public String getFloorInfo(Floor floor, ArrayList<Floor> Floors){
        if(Floors.contains(floor)){
            String msg = "Floor number "+floor.getFloorNumber()+"\n1) Total number of Spots -> "+floor.getNoOfSpots() +"\n2) Occupied Spots -> "+floor.getOccupiedSpots()+" \n3) Unoccupied spots -> "+floor.getUnoccupiedSpots()+" \n4) No. of Compact spots -> "+floor.getNoOfCompactSpots()+" \n5) No. of Large Spots -> "+floor.getNoOfLargeSpots()+" \n6) No. of Handicap Spots -> "+floor.getNoOfHandiCapSpots()+" \n7) No. of Motorcycle spots -> "+floor.getNoOfMotorCycleSpots();
            return msg;
        }
        else{
            return "Invalid Floor";
        }
    }


    // This method will check whether the floor is available in the floor list or not.
    public boolean isFloorAvailable(int floorNumber, ArrayList<Floor> Floors){
        for(Floor f: Floors){
            if(f.getFloorNumber() == floorNumber){
                return true;
            }
        }
        return false;
    }




}
