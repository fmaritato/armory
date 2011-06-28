package com.maritatf.wow.value;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class RealmList {
    private static transient Log log = LogFactory.getLog(RealmList.class);
    List<Realm> realms;

    public List<Realm> getRealms() {
        return realms;
    }

    public void setRealms(List<Realm> realms) {
        this.realms = realms;
    }

    @Override
    public String toString() {
        return "RealmList{" +
               "realms=" + realms +
               '}';
    }
}
