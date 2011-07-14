package com.maritatf.wow.value;

/**
 * @author fmaritato
 */
public enum Race {

    PLACEHOLDER(0),
    HUMAN(1),
    ORC(2),
    DWARF(3),
    NIGHT_ELF(4),
    UNDEAD(5),
    TAUREN(6),
    GNOME(7),
    TROLL(8),
    GOBLIN(9),
    BLOOD_ELF(10),
    DRANEI(11),
    WORGEN(22);

    private int id;

    Race(int id) {
        this.id = id;
    }
}
