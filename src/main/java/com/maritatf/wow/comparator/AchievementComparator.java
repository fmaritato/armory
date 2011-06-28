package com.maritatf.wow.comparator;
/**
 * @author fmaritato
 */

import com.maritatf.wow.WowToon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Comparator;

public class AchievementComparator implements Comparator {

    private static transient Log log = LogFactory.getLog(AchievementComparator.class);

    public int compare(Object o1, Object o2) {
        WowToon one = (WowToon) o1;
        WowToon two = (WowToon) o2;

        return ((Integer)two.getAchPoints()).compareTo(one.getAchPoints());
    }
}
