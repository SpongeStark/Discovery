package model;

import model.boat.Boat;
import model.enumClass.PortType;
import model.enumClass.Size;

import java.util.ArrayList;

public class Port {
    private Size size;
    private PortType portType;
    private int defense;
    private int attack;
    private int boatLimit;
    private ArrayList<Boat> boats;
}
