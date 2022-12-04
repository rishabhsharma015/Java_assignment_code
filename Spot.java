public class Spot {
    public int spotSize;
    public char spotState;
    public Spot(int spotSize){
        this.spotSize = spotSize;
        this.spotState = 'U';
    }

    public void setSpotState(char c){
        this.spotState = c;
    }
}

class Compact extends Spot{
    public Compact(){
        super(1);
    }
}

class Large extends Spot{
    public Large(){
        super(2);
    }
}

class Handicapped extends Spot{
    public Handicapped(){
        super(3);
    }
}

class Motorcycle extends Spot{
    public Motorcycle(){
        super(4);
    }
}

class ElectricVehicle extends Spot{
    public ElectricVehicle(){
        super(5);
    }
}
