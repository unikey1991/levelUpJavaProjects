package com.company.atrificial;

/**
 * Created by unike on 19.01.2017.
 */
public class TableLamp extends Lamp {
    public TableLamp(boolean isON) {
        super(isON, "Table lamp", "Лампа горит", isON?100:0, 90);
    }
}
