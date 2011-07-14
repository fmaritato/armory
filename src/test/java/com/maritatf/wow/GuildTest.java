package com.maritatf.wow;
/**
 * @author fmaritato
 */

import com.maritatf.wow.value.Guild;
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

public class GuildTest {
    private static transient Log log = LogFactory.getLog(GuildTest.class);

    @Test
    public void testGuild() throws IOException {
        String input = "{\n" +
                       "\"lastModified\":1310661125000,\n" +
                       "  \"name\":\"Resurrected\",\n" +
                       "  \"realm\":\"Crushridge\",\n" +
                       "  \"level\":25,\n" +
                       "  \"side\":1,\n" +
                       "  \"achievementPoints\":820\n" +
                       "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Guild g = objectMapper.readValue(input, Guild.class);
        assertNotNull(g);
        assertEquals("Resurrected", g.getName());
        assertEquals(25, g.getLevel());
        assertEquals(820, g.getAchievementPoints());
    }

}
