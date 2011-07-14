package com.maritatf.wow.value;

/**
 * @author fmaritato
 */
public enum WowClass {

    PLACEHOLDER(0),
    WARRIOR(1),
    PALADIN(2),
    HUNTER(3),
    ROGUE(4),
    PRIEST(5),
    DEATH_KNIGHT(6),
    SHAMAN(7),
    MAGE(8),
    WARLOCK(9),
    UNKNOWN(10),
    DRUID(11);

    private int id;
    private String name;

    WowClass(int id) {
        this.id = id;
    }


}
