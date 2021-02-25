package model;

public class CaravelWarBoat extends WarBoat{

    private int base;
    private int coefficient;
    private int sailorCarry;
    private int armyCarry;

    public CaravelWarBoat(Size size, int price, int hp) {
        super(size, price, hp);
    }
}
