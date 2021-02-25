package model.boat.warBoat;

import model.enumClass.Size;

public class BarqueWarBoat extends WarBoat {

    private int base;
    private int coefficient;
    private int sailorCarry;
    private int armyCarry;

    public BarqueWarBoat(Size size, int price, int hp) {
        super(size, price, hp);
    }
}
