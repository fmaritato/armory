package com.maritatf.wow.value;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Guild {

    private static transient Log log = LogFactory.getLog(Guild.class);

    private String name;
    private String realm;
    private int level;
    private int members;
    private int side;
    private int achievementPoints;
    private long lastModified;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
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
        return "Guild{" +
               "achievementPoints=" + achievementPoints +
               ", name='" + name + '\'' +
               ", realm='" + realm + '\'' +
               ", level=" + level +
               ", members=" + members +
               ", side=" + side +
               ", lastModified=" + lastModified +
               '}';
    }
}
