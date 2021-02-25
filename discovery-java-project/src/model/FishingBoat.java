package model;

public class FishingBoat extends Boat{

    private int fishCatch;

    public FishingBoat(Size size, int price, int hp) {
        super(size, price, hp);
    }

    public int getBaseValue(){
        switch (size){
            case SMALL:return 1;
            case MIDDLE:return 3;
            default:return 0;
        }
    }

    public int getCoefficient(){
        switch (size){
            case SMALL:return 1;
            case MIDDLE:return 3;
            default:return 0;
        }
    }


}
