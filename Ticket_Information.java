public class Ticket_Information {
    private int spotIdx;
    private Floor floor;
    private int vehicleNumber;

    public Ticket_Information(Floor floor, int spotIdx, int vehicleNumber){
        this.floor = floor;
        this.spotIdx = spotIdx;
        this.vehicleNumber = vehicleNumber;
    }

    public int getSpotIdx() {
        return spotIdx;
    }

    public Floor getFloor() {
        return floor;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }
}
