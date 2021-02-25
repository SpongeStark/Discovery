package model;

public class MerchantBoat extends Boat {
    private CarryType carryType;
    private boolean armed;

    public MerchantBoat(Size size, int price, int hp) {
        super(size, price, hp);
    }

    public int getBaseValue() {
        if (armed) {
            return 2;
        } else {
            return 10;
        }
    }

    public int getCoefficient() {
        if (armed) {
            return 3;
        } else {
            return 5;
        }
    }

    public int getCarryLimit() {
        int coefficientLimit;
        if (armed) {
            coefficientLimit = 2;
        } else {
            coefficientLimit = 1;
        }

        switch (carryType) {
            case MATERIAL:
                return coefficientLimit;
            case COMMODITY:
                return coefficientLimit * 20;
            case FINANCE:
                return coefficientLimit * 10;
            default:
                return 0;
        }
    }
}
