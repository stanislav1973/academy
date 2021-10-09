package com.company.list;

public enum InputShips {
    AIRCRAFT_CARRIER("Aircraft Carrier",5),
    BATTLESHIP("Battleship",4),
    SUBMARINES("Submarines",3),
    CRUISER("Cruiser",3),
    DESTROYER("Destroyer",2);

    private final String ship;

    private final int numberShip;

    InputShips(String ship, int numberShip) {
        this.ship = ship;
        this.numberShip = numberShip;
    }

    public String getShip() {
        return ship;
    }

    public int getNumberShip() {
        return numberShip;
    }
}
