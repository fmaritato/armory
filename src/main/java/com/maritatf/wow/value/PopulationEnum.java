package com.maritatf.wow.value;

public enum PopulationEnum {
    low("low"), medium("medium"), high("high"), na("n/a");
    String name;

    PopulationEnum(String name) {
        this.name = name;
    }

    public static PopulationEnum getValue(String name) {
        if ("n/a".equals(name)) {
            return na;
        }
        else if ("low".equals(name)) {
            return low;
        }
        else if ("medium".equals(name)) {
            return medium;
        }
        else if ("high".equals(name)) {
            return high;
        }
        throw new IllegalArgumentException("Invalid enum: "+name);
    }
}