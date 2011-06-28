package com.maritatf.wow.value;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Realm {

    private static transient Log log = LogFactory.getLog(Realm.class);

    private enum RealmTypeEnum {
        pvp, pve, rp, rppvp;
    }

    private RealmTypeEnum type;
    private boolean queue;
    private boolean status;
    private String name;
    private String slug;
    private PopulationEnum population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PopulationEnum getPopulation() {
        return population;
    }

    public void setPopulation(PopulationEnum population) {
        this.population = population;
    }

    public boolean isQueue() {
        return queue;
    }

    public void setQueue(boolean queue) {
        this.queue = queue;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RealmTypeEnum getType() {
        return type;
    }

    public void setType(RealmTypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Realm{" +
               "name='" + name + '\'' +
               ", type=" + type +
               ", queue=" + queue +
               ", status=" + status +
               ", slug='" + slug + '\'' +
               ", population=" + population +
               '}';
    }
}
