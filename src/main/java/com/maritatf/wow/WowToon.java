package com.maritatf.wow;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class WowToon {

    private static transient Log log = LogFactory.getLog(WowToon.class);

    private String name;
    private String realm;
    private String race;
    private int level;
    private String faction;
    private String className;
    private String guildName;
    private String suffix;
    private int achPoints;

    public WowToon() {
    }

    public WowToon(NamedNodeMap map) {
        Node n = map.getNamedItem("race");
        if (n != null) {
            setRace(n.getTextContent());
        }

        n = map.getNamedItem("level");
        if (n != null) {
            setLevel(Integer.parseInt(n.getTextContent()));
        }

        n = map.getNamedItem("class");
        if (n != null) {
            setClassName(n.getTextContent());
        }

        n = map.getNamedItem("faction");
        if (n != null) {
            setFaction(n.getTextContent());
        }

        n = map.getNamedItem("guildName");
        if (n != null) {
            setGuildName(n.getTextContent());
        }

        n = map.getNamedItem("suffix");
        if (n != null) {
            setSuffix(n.getTextContent());
        }

        n = map.getNamedItem("name");
        if (n != null) {
            setName(n.getTextContent());
        }

        n = map.getNamedItem("realm");
        if (n != null) {
            setRealm(n.getTextContent());
        }

        // achievement points can be known as either achPoints or points.
        n = map.getNamedItem("achPoints");
        if (n != null) {
            setAchPoints(Integer.parseInt(n.getTextContent()));
        }

        n = map.getNamedItem("points");
        if (n != null) {
            setAchPoints(Integer.parseInt(n.getTextContent()));
        }
    }

    public int getAchPoints() {
        return achPoints;
    }

    public void setAchPoints(int achPoints) {
        this.achPoints = achPoints;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    @Override
    public String toString() {
        return name + "/" + realm + ": " +
               "className='" + className + '\'' +
               ", race='" + race + '\'' +
               ", level=" + level +
               ", faction='" + faction + '\'' +
               ", guildName='" + guildName + '\'' +
               ", suffix='" + suffix + '\'' +
               ", achPoints='" + achPoints + '\''
                ;
    }
}
