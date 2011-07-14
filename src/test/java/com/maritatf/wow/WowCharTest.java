package com.maritatf.wow;
/**
 * @author fmaritato
 */

import com.maritatf.wow.value.Race;
import com.maritatf.wow.value.WowChar;
import com.maritatf.wow.value.WowClass;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WowCharTest {
    private static transient Log log = LogFactory.getLog(WowCharTest.class);

    @Test
    public void testCharacter() throws IOException {
        String input = "{\n" +
                       "\"lastModified\":1310657853000,\n" +
                       "\"name\":\"Outback\",\n" +
                       "\"realm\":\"Crushridge\",\n" +
                       "\"class\":11,\n" +
                       "\"race\":6,\n" +
                       "\"gender\":0,\n" +
                       "\"level\":85,\n" +
                       "\"achievementPoints\":8080,\n" +
                       "\"thumbnail\":\"crushridge/145/19738257-avatar.jpg\"\n" +
                       "}";

        ObjectMapper objectMapper = new ObjectMapper();
        WowChar toon = objectMapper.readValue(input, WowChar.class);
        assertNotNull(toon);
        assertEquals("Outback", toon.getName());
        assertEquals(85, toon.getLevel());
        assertEquals(8080, toon.getAchievementPoints());
        assertEquals(Race.TAUREN, toon.getRace());
        assertEquals(WowClass.DRUID, toon.getWowClass());
    }
}
