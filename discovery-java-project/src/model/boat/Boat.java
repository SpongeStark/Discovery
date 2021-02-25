package model.boat;

import model.enumClass.Size;

public class Boat {
    protected Size size;
    private int price;
    private int hp;

    public Boat(Size size, int price, int hp) {
        this.size = size;
        this.price = price;
        this.hp = hp;
    }
}
