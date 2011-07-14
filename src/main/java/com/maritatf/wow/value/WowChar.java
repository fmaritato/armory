package com.maritatf.wow.value;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.annotate.JsonProperty;
import sun.reflect.generics.repository.GenericDeclRepository;

import java.util.Map;

public class WowChar {

    private static transient Log log = LogFactory.getLog(WowChar.class);

    private String name;
    private String realm;
    private int level;
    private long lastModified;
    private String thumbnail;
    private Race race;
    private int achievementPoints;
    private Gender gender;
    @JsonProperty(value = "class")
    private WowClass wowClass;

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public WowClass getWowClass() {
        return wowClass;
    }

    public void setWowClass(WowClass wowClass) {
        this.wowClass = wowClass;
    }
}
